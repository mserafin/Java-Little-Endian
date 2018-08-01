/**
 * 
 */
package com.mserafin.io;

/**
 * Auxiliary class for converting simple numeric types to little endian format.
 * @author mserafin
 *
 */
public class Convert {
	public static int bytesToInt(final byte[] bytes) {
		int accum = 0;
		for (int i = 0; i < bytes.length; i++) {
			accum <<= 8;
			accum |= (bytes[i] & 0xFF);
		}
		return accum;
	}

	public static int bytesToIntEndian(final byte[] bytes) {
		int accum = 0;
		for (int i = bytes.length - 1; i >= 0; i--) {
			accum <<= 8;
			accum |= (bytes[i] & 0xFF);
		}
		return accum;
	}

	public static byte[] shortToBytes(short value) {
		final byte[] bytes = new byte[2];
		for (int i = 1; i >= 0; i--) {
			bytes[i] = (byte) (value & 0xff);
			value >>= 8;
		}
		return bytes;
	}

	public static byte[] intToBytes(int value) {
		final byte[] bytes = new byte[4];
		for (int i = 3; i >= 0; i--) {
			bytes[i] = (byte) (value & 0xff);
			value >>= 8;
		}
		return bytes;
	}

	public static byte[] longToBytes(long value) {
		final byte[] bytes = new byte[8];
		for (int i = 7; i >= 0; i--) {
			bytes[i] = (byte) (value & 0xff);
			value >>= 8;
		}
		return bytes;
	}

	public static byte[] shortToBytesEndian(final short value) {
		final byte[] bytes = new byte[2];
		for (int i = 0; i < 2; i++) {
			bytes[i] = (byte) ((value >> i * 8) & 0xFF);
		}
		return bytes;
	}

	public static byte[] intToBytesEndian(final int value) {
		final byte[] bytes = new byte[4];
		for (int i = 0; i < 4; i++) {
			bytes[i] = (byte) ((value >> i * 8) & 0xFF);
		}
		return bytes;
	}

	public static byte[] longToBytesEndian(final long value) {
		final byte[] bytes = new byte[8];
		for (int i = 0; i < 8; i++) {
			bytes[i] = (byte) ((value >> i * 8) & 0xFF);
		}
		return bytes;
	}

	public static short shortEndian(final short value) {
		short accum = 0;
		for (int i = 0; i < 2; i++) {
			accum <<= 8;
			accum |= ((value >> i * 8) & 0xFF);
		}
		return accum;
	}

	public static int intEndian(final int value) {
		int accum = 0;
		for (int i = 0; i < 4; i++) {
			accum <<= 8;
			accum |= ((value >> i * 8) & 0xFF);
		}
		return accum;
	}

	public static long longEndian(final long value) {
		long accum = 0;
		for (int i = 0; i < 8; i++) {
			accum <<= 8;
			accum |= ((value >> i * 8) & 0xFF);
		}
		return accum;
	}
}
