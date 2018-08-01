import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

import com.mserafin.io.LittleEndianOutputStream;

/**
 * An example of using the LittleEndianOutputStream class.
 * @author mserafin
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		final ByteArrayOutputStream output = new ByteArrayOutputStream();
		final LittleEndianOutputStream result = new LittleEndianOutputStream(output);

		/**
		 * The value is written on four bytes.
		 */
		int value = 255;

		result.writeInt(value);
		result.flush();

		byte[] littleEndian = output.toByteArray();

		byte[] bigEndian = ByteBuffer.allocate(4).putInt(value).array();

		/**
		 * Comparison of writing byte array little endian and big endian.
		 */
		System.out.println(String.format("Little Endian:\t%s", Arrays.toString(littleEndian)));

		System.out.println(String.format("Big Endian:\t%s", Arrays.toString(bigEndian)));
	}
}
