
import java.util.HashMap;
import java.util.Map;

public class Tasks {

	// Strings

	/**
	 * This function find substring between first and last appearance of certain
	 * word
	 *
	 * @return string between appearance words
	 */

	public static String interviewStringTest(String original, String appearance) {

		int firstIndex = original.indexOf(appearance);

		if (firstIndex == -1) // check for appearance in original string
			return "";
		else {
			int lastIndex = original.lastIndexOf(appearance);
			original = original.substring(firstIndex + appearance.length(), lastIndex);

		}

		return original;

	}

	// Arrays

	/**
	 * This function check the amount of appearance of certain number in source
	 * array
	 * 
	 * @return boolean value
	 */
	public static boolean interviewArrayTest(int[] array, int num, int appearance) {

		int currentNum = array[0]; // for compare values in array
		if (currentNum == num)
			--appearance;

		for (int i = 1; i < array.length; i++) { // we start from second element

			if (array[i] == num) { // check first condition : "if value equals a
									// certain number"
				--appearance;
				if (array[i] == currentNum) // check second condition : "if
											// previous value equals a certain
											// number"
					return false;
			}
			currentNum = array[i];
		}

		if (appearance == 0) // check amount of remaining appearance
			return true;

		return false;
	}

	// Recursion

	/**
	 * This function count amount of blocks in pyramid via recursion
	 * 
	 * @return amount of blocks
	 */

	public static int interviewRecursionTest(int i) {

		if (i == 0) // condition for end recursion
			return 0;

		return interviewRecursionTest(i - 1) + i;

	}

	// Map

	/**
	 * This function get array of strings and put it in the Map
	 * 
	 * @return Map with entries
	 */

	public static Map<String, Integer> interviewMapTest(String[] array) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < array.length; i++) {
			String key = array[i];
			if (map.containsKey(key)) {
				int value = map.get(key); // Get old value
				map.put(key, value + 1); // rewrite it
			} else {
				map.put(key, 1); // put new entry
			}
		}
		return map;

	}
}
