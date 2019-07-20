package reverse;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter String to reverse :");
		@SuppressWarnings("resource")
		
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		System.out.print("Enter String to reverse is :" + string);
		StringBuilder reversed = new StringBuilder("");
		
		for (int i = string.length(); i > 0; i--) {
			reversed = reversed.append(string.charAt(i - 1));
		}
		
		System.out.print("reversed String is :" + reversed);
	}
}
