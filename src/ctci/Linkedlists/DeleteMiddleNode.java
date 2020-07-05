package ctci.Linkedlists;

import ctci.Linkedlists.LinkedListHelper.Node;

public class DeleteMiddleNode {
	static Node head = LinkedListHelper.makeLL(7);

	public static void main(String[] args) {
		deleteMiddle(head.next.next.next);
		System.gc();
	}

	public static void deleteMiddle(Node node) {
		if (node == null || node.next == null) {
			return;
		}
		node.data = node.next.data;
		node.next = node.next.next;

		LinkedListHelper.printLL(head);
	}
}
