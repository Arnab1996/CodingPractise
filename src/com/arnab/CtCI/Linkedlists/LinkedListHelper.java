package com.arnab.CtCI.Linkedlists;

import java.util.Random;

public class LinkedListHelper {
	static class Node {
		int data;
		Node prev, next;

		Node(int data) {
			this.data = data;
			prev = next = null;
		}
	}

	static Node head;

	public static Node deleteLL(Node head, int data) {
		if (head.data == data && head.next == null) {
			return null;
		}
		if (head.data == data) {
			return head.next;
		}
		Node cur = head;
		while (cur.next != null) {
			if (cur.next.data == data) {
				cur.next = cur.next.next;
				return head;
			}
			cur = cur.next;
		}
		return head;
	}

	public static int countLL(Node head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}

	public static Node makeLL(int len) {
		Random random = new Random();
		Node current = new Node(random.nextInt(10));
		head = current;
		while (len-- > 1) {
			current.next = new Node(random.nextInt(10));
			current = current.next;
		}
		printLL(head);
		return head;
	}

	public static void printLL(Node head) {
		if (head == null) {
			return;
		}
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("X");
		System.out.println();
		System.gc();
	}
}
