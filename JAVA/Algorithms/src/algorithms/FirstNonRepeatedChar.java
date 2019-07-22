package algorithms;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedChar {

	/* Find first non repeated character from string O(n) */

	public static char firstNonRepeated(String inputString) {
		// TODO Auto-generated method stub

		Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		int inputStringLen = inputString.length();

		for (int i = 0; i < inputString.length(); i++) {

			int charCount;

			if (charCountMap.containsKey(inputString.charAt(i))) {
				charCount = charCountMap.get(inputString.charAt(i));
			} else {
				charCount = 0;
			}

			if (charCount > 0) {
				charCountMap.put(inputString.charAt(i), charCount + 1);
			} else {
				charCountMap.put(inputString.charAt(i), charCount);
			}
		}

		for (int i = 0; i < inputStringLen; i++) {

			char character = inputString.charAt(i);

			if (charCountMap.get(character) == 0) {
				return character;
			}
		}

		return 0;
	}

}
