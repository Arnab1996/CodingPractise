package ctci.Linkedlists;

import ctci.Linkedlists.LinkedListHelper.Node;

public class SumLists {
	static Node head1 = LinkedListHelper.makeLL(7);
	static Node head2 = LinkedListHelper.makeLL(7);

	public static void main(String[] args) {
		Node sum = sumList(head1, head2);
		LinkedListHelper.printLL(sum);
		System.gc();
	}

	public static Node sumList(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return null;
		}
		Node sumResult = null;
		Node temp = null;
		Node head = null;
		int len1 = LinkedListHelper.countLL(node1);
		int len2 = LinkedListHelper.countLL(node2);
		int sum = 0;
		int carry = 0;
		if (len1 > len2) {
			head = node2;
			while (head.next != null) {
				head = head.next;
			}
			for (int i = 0; i < len1 - len2; i++) {
				temp = new Node(0);
				head.next = temp;
				head = temp;
			}
		} else {
			head = node1;
			while (head.next != null) {
				head = head.next;
			}
			for (int i = 0; i < len2 - len1; i++) {
				temp = new Node(0);
				head.next = temp;
				head = temp;
			}
		}
		head = null;
		while (node1 != null) {
			sum = node1.data + node2.data + carry;
			if (sum >= 10) {
				sum = sum % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			if (sumResult == null) {
				sumResult = new Node(sum);
				head = sumResult;
			} else {
				temp = new Node(sum);
				sumResult.next = temp;
				sumResult = temp;
				if (node1.next == null && carry == 1) {
					temp = new Node(1);
					sumResult.next = temp;
				}
			}
			node1 = node1.next;
			node2 = node2.next;
		}

		return head;
	}
}
