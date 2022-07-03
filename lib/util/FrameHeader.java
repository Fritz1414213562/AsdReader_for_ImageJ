package lib.util;
import java.io.*;


public class FrameHeader {
	public int     number;
	public short   max_data;
	public short   min_data;
	public short   x_offset;
	public short   y_offset;
	public float   x_tilt;
	public float   y_tilt;
	public boolean is_stimulated;
	public byte[]  _booked1;
	public short   _booked2;
	public int     _booked3;
	public int     _booked4;

	public void dump(String fname) {
		try {
			File file = new File(fname);
			FileWriter writer = new FileWriter(file);
			writer.write(String.format("Frame Number        : %d", number));
			writer.write(String.format("Maximum data        : %d", max_data));
			writer.write(String.format("Minimum data        : %d", min_data));
			writer.write(String.format("X offset (nm)       : %d", x_offset));
			writer.write(String.format("Y offset (nm)       : %d", y_offset));
			writer.write(String.format("X tilt              : %f", x_tilt));
			writer.write(String.format("Y tilt              : %f", y_tilt));
			writer.write(String.format("Flag of stimulation : %b", is_stimulated));
			writer.write(String.format("Booked              : %s", _booked1));
			writer.write(String.format("Booked              : %d", _booked2));
			writer.write(String.format("Booked              : %d", _booked3));
			writer.write(String.format("Booked              : %d", _booked4));
			writer.close();
		} catch(IOException e) {
			System.out.println(e);
		}
	}
}
