package lib;

import java.io.*;
import lib.util.Header;
import lib.util.ReadBinary;
import lib.util.enums.*;


public class ReadHeader {

	public static Header run(BufferedInputStream source) {

		
		Header retval = new Header();

		retval.file_version         = ReadBinary.AsInt(source);
		retval.file_header_size     = ReadBinary.AsInt(source);
		retval.frame_header_size    = ReadBinary.AsInt(source);
		retval.text_encoding        = Encode.valueFrom(ReadBinary.AsInt(source));
		int op_name_size            = ReadBinary.AsInt(source);
		retval.operator_name_size   = op_name_size;
		int cmt_size                = ReadBinary.AsInt(source);
		retval.comment_size         = cmt_size;
		retval.data_kind_1ch        = DataKind.valueFrom(ReadBinary.AsInt(source));
		retval.data_kind_2ch        = DataKind.valueFrom(ReadBinary.AsInt(source));
		retval.init_frame           = ReadBinary.AsInt(source);
		retval.num_frames           = ReadBinary.AsInt(source);
		retval.scanning_direction   = ScanDirect.valueFrom(ReadBinary.AsInt(source));
		retval.file_id              = ReadBinary.AsInt(source);
		retval.x_pixel              = ReadBinary.AsInt(source);
		retval.y_pixel              = ReadBinary.AsInt(source);
		retval.x_scanning_range     = ReadBinary.AsInt(source);
		retval.y_scanning_range     = ReadBinary.AsInt(source);
		retval.is_averaged          = ReadBinary.AsBoolean(source);
		retval.average_window       = ReadBinary.AsInt(source);
		retval.year                 = ReadBinary.AsInt(source);
		retval.month                = ReadBinary.AsInt(source);
		retval.day                  = ReadBinary.AsInt(source);
		retval.hour                 = ReadBinary.AsInt(source);
		retval.minute               = ReadBinary.AsInt(source);
		retval.second               = ReadBinary.AsInt(source);
		retval.x_rounding_degree    = ReadBinary.AsInt(source);
		retval.y_rounding_degree    = ReadBinary.AsInt(source);
		retval.frame_acquision_time = ReadBinary.AsFloat(source);
		retval.sensor_sensitivity   = ReadBinary.AsFloat(source);
		retval.phase_sensitivity    = ReadBinary.AsFloat(source);
		retval.offset               = ReadBinary.AsInt(source);
		ReadBinary.AsBytes(source, 12);
		retval.machine_id           = ReadBinary.AsInt(source);
		retval.ad_range             = ADRange.valueFrom(ReadBinary.AsInt(source));
		retval.ad_resolution        = ReadBinary.AsInt(source);
		retval.x_max_scanning_range = ReadBinary.AsFloat(source);
		retval.y_max_scanning_range = ReadBinary.AsFloat(source);
		retval.x_piezo_extension    = ReadBinary.AsFloat(source);
		retval.y_piezo_extension    = ReadBinary.AsFloat(source);
		retval.z_piezo_extension    = ReadBinary.AsFloat(source);
		retval.z_piezo_gain         = ReadBinary.AsFloat(source);
		retval.operator_name        = ReadBinary.AsString(source, op_name_size);
		retval.comment              = ReadBinary.AsString(source, cmt_size);

		return retval;
	}
}
