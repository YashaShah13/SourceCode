package algorithms;

import java.util.Scanner;

import java.util.HashMap;

import java.util.Map;

public class FindRepeated {

	/* Find duplicate character from given string o(n) */

	public static boolean findDuplicates(String inputString) {
		// TODO Auto-generated method stub

		int inputStringLen = inputString.length();
		boolean duplicateFound = false;
		Map<Character, Integer> charMap = new HashMap<Character, Integer>(); // unique characters as key and their count
																											// as value

		for (int i = 0; i < inputStringLen; i++) {

			Character ch = inputString.charAt(i);

			if (charMap.containsKey(ch) == false) {
				charMap.put(ch, 0);
			} else {
				charMap.put(ch, charMap.get(ch) + 1); // if character is already in charMap, increment count value
			}

		}

		for (Character chIterator : charMap.keySet()) { // for each character in key set

			if (charMap.get(chIterator) > 0) {
				duplicateFound = true;
				System.out.println("Duplicate found: " + chIterator);
			}
		}

		return duplicateFound;
	}

}
