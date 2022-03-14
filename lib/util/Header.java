package lib.util;

import lib.util.enums.ADRange;
import lib.util.enums.DataKind;
import lib.util.enums.Encode;
import lib.util.enums.ScanDirect;


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
}
