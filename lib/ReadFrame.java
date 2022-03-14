package lib;

import java.io.*;
import lib.util.FrameHeader;
import lib.util.ReadBinary;


public class ReadFrame {

	public static FrameHeader readHeader(BufferedInputStream source) {
		FrameHeader retval = new FrameHeader();
		retval.number        = ReadBinary.AsInt(source);
		retval.max_data      = ReadBinary.AsShort(source);
		retval.min_data      = ReadBinary.AsShort(source);
		retval.x_offset      = ReadBinary.AsShort(source);
		retval.y_offset      = ReadBinary.AsShort(source);
		retval.x_tilt        = ReadBinary.AsFloat(source);
		retval.y_tilt        = ReadBinary.AsFloat(source);
		retval.is_stimulated = ReadBinary.AsBoolean(source);
		retval._booked1      = ReadBinary.AsBytes(source, 1);
		retval._booked2      = ReadBinary.AsShort(source);
		retval._booked3      = ReadBinary.AsInt(source);
		retval._booked4      = ReadBinary.AsInt(source);

		return retval;
	}

	public static short[] readData(BufferedInputStream source, int x_pixel, int y_pixel) {
		short[] frame = new short[x_pixel * y_pixel];
		for (int icol = y_pixel - 1; icol >= 0; --icol) {
			for (int irow = 0; irow < x_pixel; ++irow) {
				frame[irow + x_pixel * icol] = ReadBinary.AsShort(source);
			}
		}
		return frame;
	}
}
