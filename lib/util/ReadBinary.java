package lib.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.*;

public class ReadBinary {
	public static short AsShort(BufferedInputStream source) {
		byte[] bytes = new byte[2];
		try {
			source.read(bytes, 0, 2);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getShort();
	}

	public static int AsInt(BufferedInputStream source) {
		byte[] bytes = new byte[4];
		try {
			source.read(bytes, 0, 4);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getInt();
	}

	public static float AsFloat(BufferedInputStream source) {
		byte[] bytes = new byte[4];
		try {
			source.read(bytes, 0, 4);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();
	}

	public static boolean AsBoolean(BufferedInputStream source) {
		byte[] bytes = new byte[1];
		try {
			source.read(bytes, 0, 1);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return bytes[0] != 0;
	}

	public static byte[] AsBytes(BufferedInputStream source, int bytes_size) {
		byte[] bytes = new byte[bytes_size];
		try {
			source.read(bytes, 0, bytes_size);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}

	public static String AsString(BufferedInputStream source, int string_size) {
		byte[] bytes = new byte[string_size];
		try {
			source.read(bytes, 0, string_size);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		String retval = new String(bytes);
		return retval;
	}
}
