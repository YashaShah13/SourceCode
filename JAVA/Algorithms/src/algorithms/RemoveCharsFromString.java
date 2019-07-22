package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveCharsFromString {

	public static String removeChars(String string, String removeString) {
		// TODO Auto-generated method stub

		int removeStringLen = removeString.length();
		
		Set<Character> uniqueChars = new HashSet<Character>(removeStringLen);

		for (int i = 0; i < removeStringLen; i++) {
			uniqueChars.add(removeString.charAt(i));
		}

		StringBuilder tempString = new StringBuilder("");

		for (int i = 0; i < string.length(); i++) {
			if (!uniqueChars.contains(string.charAt(i))) {
				tempString.append(string.charAt(i));
			}
		}

		return tempString.toString();
	}

}
