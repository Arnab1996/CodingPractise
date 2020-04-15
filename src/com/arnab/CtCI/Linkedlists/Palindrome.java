package com.arnab.CtCI.Linkedlists;

import com.arnab.CtCI.Linkedlists.LinkedListHelper.Node;

public class Palindrome {
	static Node head = LinkedListHelper.makeLL(4);

	public static void main(String[] args) {
		System.out.println(isPalindrome(head));
		System.gc();
	}

	public static boolean isPalindrome(Node head) {
		if (head == null) {
			return false;
		}
		int len = LinkedListHelper.countLL(head);
		boolean flag = true;
		while (head != null && len > 0) {
			Node cur = head;
			for (int i = 0; i < len - 1; i++) {
				cur = cur.next;
			}
			len -= 2;
			if (head.data == cur.data) {
				head = head.next;
				continue;
			} else {
				flag = false;
				break;
			}

		}
		return flag;
	}
}
