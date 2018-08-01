package com.mserafin.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Write primitive numeric types to stream in little endian format.
 * 
 * @author mserafin
 *
 */
public class LittleEndianOutputStream extends FilterOutputStream {
	public LittleEndianOutputStream(final OutputStream out) {
		super(out);
	}

	/**
	 * Append the byte array to the stream.
	 * 
	 * @param value
	 *            The value of the primitive type to write.
	 * @throws IOException
	 */
	@Override
	public void write(final byte[] value) throws IOException {
		out.write(value);
	}

	/**
	 * Writing the value on one byte.
	 * 
	 * @param value
	 *            The value of the primitive type to write.
	 * @throws IOException
	 */
	public void writeByte(final byte value) throws IOException {
		this.write(new byte[] { value });
	}

	/**
	 * Writing the value on one byte.
	 * 
	 * @param value
	 *            The value of the primitive type to write.
	 * @throws IOException
	 */
	public void writeByte(final int value) throws IOException {
		this.writeByte((byte) value);
	}

	/**
	 * Writing the value on two bytes.
	 * 
	 * @param value
	 *            The value of the primitive type to write.
	 * @throws IOException
	 */
	public void writeShort(final short value) throws IOException {
		this.write(Convert.shortToBytesEndian(value));
	}

	/**
	 * Writing the value on two bytes. It casts a value from long to short.
	 * 
	 * @param value
	 *            The value of the primitive type to write.
	 * @throws IOException
	 */
	public void writeUnsignedShort(final long value) throws IOException {
		writeShort((short) value);
	}

	/**
	 * Writing the value on four bytes.
	 * 
	 * @param value
	 *            The value of the primitive type to write.
	 * @throws IOException
	 */
	public void writeInt(final int value) throws IOException {
		this.write(Convert.intToBytesEndian(value));
	}

	/**
	 * Writing the value on four bytes. It casts a value from long to int.
	 * 
	 * @param value
	 *            The value of the primitive type to write.
	 * @throws IOException
	 */
	public void writeUnsignedInt(final long value) throws IOException {
		writeInt((int) value);
	}

	/**
	 * Writing the value on eight bytes.
	 * 
	 * @param value
	 *            The value of the primitive type to write.
	 * @throws IOException
	 */
	public void writeLong(final long value) throws IOException {
		this.write(Convert.longToBytesEndian(value));
	}

	/**
	 * Writing the value on one byte.
	 * 
	 * @param value
	 *            The value of the primitive type to write.
	 * @throws IOException
	 */
	public void writeBoolean(final boolean value) throws IOException {
		this.writeByte((byte) (value ? 1 : 0));
	}
}
