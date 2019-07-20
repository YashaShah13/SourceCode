package linklist;

public class List {

	Node head = null;

	// INSERT NODE X AT BIGINNING OF LIST

	public void InsertatFront(List list, Node node) {

		if (list.head == null) {

			node.prev = head;
			list.head = node;
			System.out.println("First node");

		} else {

			node.prev = list.head.prev;
			node.next = list.head;
			list.head.prev = node;
			list.head = node;
			System.out.println("node inserted");
		}
	}

	// PRINT THE WHOLE LIST

	public void PrintList(List list) {
		// TODO Auto-generated method stub
		Node node = list.head;
		while (node.next != null) {

			System.out.println(node.key);
			node = node.next;
		}
		System.out.println(node.key);
	}

	// INSERT NODE X AT THE END OF LIST

	public void InsertatBack(List list, Node node) {
		// TODO Auto-generated method stub
		Node runnerNode = list.head;
		if (list.head == null) {

			node.prev = list.head;
			list.head = node;
		} else {

			while (runnerNode.next != null) {

				runnerNode = runnerNode.next;
			}
			runnerNode.next = node;
			node.prev = runnerNode;
		}
	}

	// DELETE THE NODE CONTAINING VALUE Y

	public void DeleteElement(List list, int y) {
		// TODO Auto-generated method stub
		Node runnerNode = list.head;

		while (runnerNode.key != y && runnerNode.next != null) {

			runnerNode = runnerNode.next;
		}
		if (runnerNode.next == null) {

			System.out.println("key is not in the list");
		}
		list.head = runnerNode.next;
		runnerNode.next.prev = runnerNode;
	}

}
