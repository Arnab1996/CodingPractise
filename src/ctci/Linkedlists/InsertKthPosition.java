package ctci.Linkedlists;

import ctci.Linkedlists.LinkedListHelper.Node;

public class InsertKthPosition {
	static Node head = LinkedListHelper.makeLL(7);

	public static void main(String[] args) {
		head = insert(head, 15, 3);
		LinkedListHelper.printLL(head);
	}

	public static Node insert(Node head, int data, int pos) {
		Node cur = new Node(data);
		if (head == null && pos == 0) {
			return cur;
		}

		Node temp = head;
		for (int i = 1; i < pos; i++) {
			temp = temp.next;
		}
		cur.next = temp.next;
		temp.next = cur;
		return head;
	}
}
