package lib.util;

import lib.util.enums.ADRange;
import lib.util.enums.DataKind;
import lib.util.enums.Encode;
import lib.util.enums.ScanDirect;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Header {
	public int file_version;
	public int file_header_size;
	public int frame_header_size;
	public Encode text_encoding;
	public int operator_name_size;
	public int comment_size;
	public DataKind data_kind_1ch;
	public DataKind data_kind_2ch;
	public int init_frame;
	public int num_frames;
	public ScanDirect scanning_direction;
	public int file_id;
	public int x_pixel;
	public int y_pixel;
	public int x_scanning_range;
	public int y_scanning_range;
	public boolean is_averaged;
	public int average_window;
	public int year;
	public int month;
	public int day;
	public int hour;
	public int minute;
	public int second;
	public int x_rounding_degree;
	public int y_rounding_degree;
	public float frame_acquision_time;
	public float sensor_sensitivity;
	public float phase_sensitivity;
	public int offset;
	public int machine_id;
	public ADRange ad_range;
	public int ad_resolution;
	public float x_max_scanning_range;
	public float y_max_scanning_range;
	public float x_piezo_extension;
	public float y_piezo_extension;
	public float z_piezo_extension;
	public float z_piezo_gain;
	public String operator_name;
	public String comment;

	public void dump(String fname) {
		try {
			File file = new File(fname);
			FileWriter writer = new FileWriter(file);
			writer.write(String.format("File Version            : %d\n", file_version));
			writer.write(String.format("Header size             : %d\n", file_header_size));
			writer.write(String.format("Frame header size       : %d\n", frame_header_size));
			writer.write(String.format("Text Encoding           : %s\n", text_encoding));
			writer.write(String.format("Operator name size      : %d\n", operator_name_size));
			writer.write(String.format("Comment size            : %d\n", comment_size));
			writer.write(String.format("Data kind of 1ch        : %s\n", data_kind_1ch));
			writer.write(String.format("Data kind of 2ch        : %s\n", data_kind_2ch));
			writer.write(String.format("Initial frame           : %d\n", init_frame));
			writer.write(String.format("Frame number            : %d\n", num_frames));
			writer.write(String.format("Scanning direction      : %s\n", scanning_direction));
			writer.write(String.format("File ID                 : %d\n", file_id));
			writer.write(String.format("X pixel number          : %d\n", x_pixel));
			writer.write(String.format("Y pixel number          : %d\n", y_pixel));
			writer.write(String.format("X scanning range        : %d\n", x_scanning_range));
			writer.write(String.format("Y scanning range        : %d\n", y_scanning_range));
			writer.write(String.format("Frame averaged          : %b\n", is_averaged));
			writer.write(String.format("Average window          : %d\n", average_window));
			writer.write(String.format("Year                    : %d\n", year));
			writer.write(String.format("Month                   : %d\n", month));
			writer.write(String.format("Day                     : %d\n", day));
			writer.write(String.format("Hour                    : %d\n", hour));
			writer.write(String.format("Minute                  : %d\n", minute));
			writer.write(String.format("Second                  : %d\n", second));
			writer.write(String.format("X rounding degree       : %d\n", x_rounding_degree));
			writer.write(String.format("Y rounding degree       : %d\n", y_rounding_degree));
			writer.write(String.format("Frame acquision time    : %f\n", frame_acquision_time));
			writer.write(String.format("Sensor sensitivity      : %f\n", sensor_sensitivity));
			writer.write(String.format("Phase sensitivity       : %f\n", phase_sensitivity));
			writer.write(String.format("Offset                  : %d\n", offset));
			writer.write(String.format("Machine id              : %d\n", machine_id));
			writer.write(String.format("AD range                : %s\n", ad_range));
			writer.write(String.format("AD resolution           : %d\n", ad_resolution));
			writer.write(String.format("X max scanning range    : %f\n", x_max_scanning_range));
			writer.write(String.format("Y max scanning range    : %f\n", y_max_scanning_range));
			writer.write(String.format("X piezo extension       : %f\n", x_piezo_extension));
			writer.write(String.format("Y piezo extension       : %f\n", y_piezo_extension));
			writer.write(String.format("Z piezo extension       : %f\n", z_piezo_extension));
			writer.write(String.format("Z piezo gain            : %f\n", z_piezo_gain));
			writer.write(String.format("Operator name           : %s\n", operator_name));
			writer.write(String.format("Comment                 : %s\n", comment));
			writer.close();
		} catch(IOException e) {
			System.out.println(e);
		}
	}
}
