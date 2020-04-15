package com.arnab.CtCI.Linkedlists;

import com.arnab.CtCI.Linkedlists.LinkedListHelper.Node;

public class RemoveDups {
	public static void main(String[] args) {
		Node head = LinkedListHelper.makeLL(7);
		removeDups(head);
	}

	public static void removeDups(Node head) {
		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
		LinkedListHelper.printLL(head);
	}
}
