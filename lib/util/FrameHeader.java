package lib.util;


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
}
