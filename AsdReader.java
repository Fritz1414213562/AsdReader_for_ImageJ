import ij.*;
import ij.plugin.*;
import ij.process.*;
import ij.gui.*;
import ij.io.*;
import java.io.*;
import java.lang.*;
import lib.*;
import lib.util.*;
import lib.util.enums.*;


public class AsdReader implements PlugIn {

	private final int image_width = 500;

	public void run(String arg) {
		OpenDialog od = new OpenDialog("Select Asd File", arg);
		String file_name = od.getFileName();
		if (file_name == null) return;
		String file_dir = od.getDirectory();
		String path = file_dir + file_name;
		try (BufferedInputStream ifs = new BufferedInputStream(new FileInputStream(new File(path)))) {

			Header file_header = ReadHeader.run(ifs);
			DataKind dk_1ch = file_header.data_kind_1ch;
			DataKind dk_2ch = file_header.data_kind_2ch;

			if (dk_2ch == DataKind.None) { // when using 1ch ver.
				ImageStack stack = new ImageStack();
				// read frames
				stack = makeStack(ifs, file_header, dk_1ch);
				// zoom in images
				ImagePlus imp = new ImagePlus(WindowManager.getUniqueName(file_name), stack);
				imp = ij.plugin.Scaler.resize(imp, image_width, image_width, 1, "none");
				// show
				FileInfo fi = new FileInfo();
				fi.fileName = file_name;
				fi.directory = file_dir;
				imp.setFileInfo(fi);
				if (arg.equals("")) imp.show();
			}
			else {
				// read frames
				ImageStack stack1ch = makeStack(ifs, file_header, dk_1ch);
				ImageStack stack2ch = makeStack(ifs, file_header, dk_2ch);

				// zoom in images
				ImagePlus imp1ch = new ImagePlus("Untitled", stack1ch);
				imp1ch = ij.plugin.Scaler.resize(imp1ch, image_width, image_width, 1, "none");
				imp1ch.setTitle(WindowManager.getUniqueName(file_name + ":1ch"));
				ImagePlus imp2ch = new ImagePlus("Untitled", stack2ch);
				imp2ch = ij.plugin.Scaler.resize(imp2ch, image_width, image_width, 1, "none");
				imp2ch.setTitle(WindowManager.getUniqueName(file_name + ":2ch"));
				// show
				FileInfo fi = new FileInfo();
				fi.fileName = file_name;
				fi.directory = file_dir;
				imp1ch.setFileInfo(fi);
				imp2ch.setFileInfo(fi);
				if (arg.equals("")) imp1ch.show();
				if (arg.equals("")) imp2ch.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ImageStack makeStack(BufferedInputStream source, Header header, DataKind data_kind) {
		int x_pixel = header.x_pixel;
		int y_pixel = header.y_pixel;
		int num_frames = header.num_frames;
		ImageStack retval = new ImageStack(x_pixel, y_pixel, num_frames);

		for (int iframe = 0; iframe < num_frames; ++iframe) {
			FrameHeader fheader = ReadFrame.readHeader(source);
			float[] pixels = convertFrame(ReadFrame.readData(source, x_pixel, y_pixel), header, data_kind);
			retval.setPixels(pixels, iframe + 1);
		}
		return retval;
	}


	private VoltageLevelConverter makeVLConverter(ADRange adrange, long resolution) {
		switch(adrange) {
			case unipolar_1_0V:
				return new UnipolarConverter((float) 1.0, resolution);
			case unipolar_2_5V:
				return new UnipolarConverter((float) 2.5, resolution);
			case unipolar_5_0V:
				return new UnipolarConverter((float) 5.0, resolution);
			case bipolar_1_0V:
				return new BipolarConverter((float) 1.0, resolution);
			case bipolar_2_5V:
				return new BipolarConverter((float) 2.5, resolution);
			case bipolar_5_0V:
				return new BipolarConverter((float) 5.0, resolution);
			case dummy_value:
				return new BipolarConverter((float) 80.0, resolution);
			default:
				throw new IllegalArgumentException(String.format("Invalid AD_range value: %", adrange));
		}
	}

	private float[] convertFrame(short[] pixels, Header header, DataKind data_kind) {
		float[] retval = new float[pixels.length];
		VoltageLevelConverter converter = makeVLConverter(header.ad_range, (1 << header.ad_resolution));

		float coef = 0;

		switch(data_kind) {
			case Topography:
				coef = header.z_piezo_gain * header.z_piezo_extension;
				break;
			case Error:
				coef = (float) -1.0 * header.sensor_sensitivity;
				break;          
			case Phase:        
				coef = (float) -1.0 * header.phase_sensitivity;
				break;
			case None:
				coef = (float) 0.0;
				break;
			default:
				throw new IllegalArgumentException(String.format("Invalid data kind value: %", data_kind));
		}
		for (int idx = 0; idx < pixels.length; ++idx)
			retval[idx] = coef * converter.levelToVoltage(pixels[idx]);

		return retval;
	}

}
