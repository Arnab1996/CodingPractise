package com.arnab.CtCI.Linkedlists;

import com.arnab.CtCI.Linkedlists.LinkedListHelper.Node;

public class Partition {
	static Node head = LinkedListHelper.makeLL(7);

	public static void main(String[] args) {
		Node ans = partition(head, 40);
		LinkedListHelper.printLL(ans);
		System.gc();
	}

	public static Node partition(Node node, int i) {
		if (node == null) {
			return null;
		}
		Node before = null;
		Node after = null;
		
		while (node != null) {
			Node next = node.next;
			if (node.data < i) {
				node.next = before;
				before = node;
			} else {
				node.next = after;
				after = node;
			}
			node = next;
		}
		Node ans = before;

		if (before == null) {
			return after;
		}
		while (before.next != null) {
			before = before.next;
		}

		before.next = after;
		return ans;

	}
}
