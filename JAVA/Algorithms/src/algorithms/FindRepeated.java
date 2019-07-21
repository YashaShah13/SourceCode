package algorithms;

import java.util.Scanner;

import java.util.HashMap;

import java.util.Map;

public class FindRepeated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter string :");

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		String string = input.nextLine();

		if(!findDuplicates(string)) {
			System.out.println("Duplicate not found");
		}
	}

	private static boolean findDuplicates(String string) {
		// TODO Auto-generated method stub

		Map<Character, Integer> charMap = new HashMap<Character, Integer>(); // unique characters as key and their count
		// as
		// value

		for (int i = 0; i < string.length(); i++) {
			Character ch = string.charAt(i);

			if (charMap.containsKey(ch) == false) {
				charMap.put(ch, 0);
			} else {
				charMap.put(ch, charMap.get(ch) + 1); // if character is already in charMap, increment count value
			}

		}
		
		boolean duplicateFound=false;

		for (Character chIterator : charMap.keySet()) { // for each character in key set
			if (charMap.get(chIterator) > 0) {
				duplicateFound=true;
				System.out.println("Duplicate found: " + chIterator);
			}
		}
		
		return duplicateFound;
	}

}
