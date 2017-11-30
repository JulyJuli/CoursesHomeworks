
import java.util.ArrayList;
import java.util.List;

//This Application convert symbols from ASCII-table to custom format
public class Application {


	/**
	 * This function pass source symbol to auxiliary functions
	 * 
	 * @return converted string
	 */

	public static String toCustomEncoding(String m) {

		StringBuilder sb = new StringBuilder();
		String binaryLine = convertToBinary(m.getBytes());

		String[] firstBlock = getFirstBlock(getTrimedBinary(binaryLine).split("")); // get
																					// first
																					// blocks
	
		String[] secondBlock = countBinaryRepeat(binaryLine.split("")).split(" "); // get
																					// second
																					// blocks
		for (int i = 0; i < firstBlock.length; i++) { // joint blocks
			sb.append(firstBlock[i] + " ");
			sb.append(secondBlock[i] + " ");
		}

		return sb.toString();

	}

	
	/**
	 * This function get binary string and trim it for future converting
	 * 
	 * @return trimed string
	 */

	public static String getTrimedBinary(String str) {

		char tmp = str.charAt(0);

		String result = String.valueOf(tmp);

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != tmp) {
				result = result + str.charAt(i);
			}
			tmp = str.charAt(i);
		}
		return result;

	}

	
	/**
	 * This function get trim binary string and convert it to the first blocks
	 * 
	 * @return first blocks of custom encoding
	 */

	public static String[] getFirstBlock(String[] s) {

		List<String> result = new ArrayList<String>();
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("0"))
				result.add("00");
			else
				result.add("0");
		}

		return result.toArray(new String[result.size()]);
	}

	
	/**
	 * This function convert source symbol to binary code
	 * 
	 * @return converted string in binary format
	 */

	public static String convertToBinary(byte[] bytes) {

		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			for (int i = 0; i < 8; i++) {
				sb.append((b & 128) == 0 ? "0" : "1");
				b <<= 1;
			}

		}
		return sb.toString();

	}

	
	/**
	 * This function get binary string and convert it to the second blocks
	 * 
	 * @return string with second blocks
	 */

	public static String countBinaryRepeat(String[] s) {

		String currentSymb = s[0];
		String result = "0";

		for (int i = 1; i < s.length; i++) {

			if (s[i].compareTo(currentSymb) == 0) 
				result += "0";
			else
				result += " 0";

			currentSymb = s[i];
		}

		return result;
	}

}
