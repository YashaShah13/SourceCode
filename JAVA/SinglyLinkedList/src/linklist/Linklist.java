package linklist;

import java.util.Scanner;

public class Linklist {

	public static void main(String[] args) {

		List list = new List();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Node node;

		for (int i = 0; i < 10; i++) {
			System.out.println("Enter Key : ");
			int data = input.nextInt();
			node = new Node(data);
			list.InsertatBack(list, node);
		}

		list.PrintList(list);

		System.out.println("Enter the value to delete :");
		int y = input.nextInt();

		list.DeleteElement(list, y);

		list.PrintList(list);
	}
}