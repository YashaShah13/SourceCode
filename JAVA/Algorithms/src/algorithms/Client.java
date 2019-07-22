package algorithms;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter string :");

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String string = input.nextLine();
		
		while (string.trim().isEmpty()) {
			System.out.print("Enter string :");
			string = input.nextLine();
		}

		boolean terminate = false;

		while (!terminate) {

			System.out.println("***************************************************");
			System.out.println("Press a to print duplicate characters:");
			System.out.println("Press b to remove characters from string:");
			System.out.println("Press c to reverse the order of words:");
			System.out.println("Press d to print first non repeated character:");
			System.out.println("Press e to exit: ");
			System.out.println("***************************************************");
			System.out.println("Enter Your choice: ");

			char choice = input.nextLine().charAt(0);

			switch (choice) {

			case 'a': {
				
				if (!FindRepeated.findDuplicates(string)) {
					System.out.println("Duplicate not found");
				}
			}
				break;

			case 'b': {
				
				System.out.println("Enter characters to remove as a string: ");
				String removeString = input.nextLine();

				String newString = RemoveCharsFromString.removeChars(string, removeString);

				System.out.println("String without character is : " + newString);
			}
				break;

			case 'c': {
				
				String reversedString = ReverseWordOrder.reverseorder(string);
				System.out.println("Reversed word order string is : " + reversedString);
			}
				break;

			case 'd': {
				
				char firstNonrepeatedCh = FirstNonRepeatedChar.firstNonRepeated(string);
				System.out.println("First non repeated character is : " + firstNonrepeatedCh);
			}
				break;

			case 'e': {
				
				terminate = true;
				System.out.println("Thank you!!");
			}
				break;

			default: {
				
				System.out.println("Enter a valid choice");
			}

			}

			
		}
	}

}
