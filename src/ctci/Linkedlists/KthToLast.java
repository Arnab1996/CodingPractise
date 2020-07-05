package ctci.Linkedlists;

import ctci.Linkedlists.LinkedListHelper.Node;

public class KthToLast {
	public static void main(String[] args) {
		Node head = LinkedListHelper.makeLL(7);
		System.out.println(kth(head, 4));
		System.out.println(kth_optimized(head, 4));
	}

	public static int kth_optimized(Node head, int k) {
		if (head == null) {
			return -1;
		}
		Node p1 = head;
		Node p2 = head;

		for (int i = 0; i < k; i++) {
			if (p1 == null) {
				return -1;
			}
			p1 = p1.next;
		}
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2.data;

	}

	public static int kth(Node head, int k) {
		if (head == null) {
			return -1;
		}
		int count = LinkedListHelper.countLL(head);
		int i = 0;
		while (head != null && i != (count - k)) {
			head = head.next;
			i++;
		}
		return head.data;
	}
}
