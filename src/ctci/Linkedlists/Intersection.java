package ctci.Linkedlists;

import ctci.Linkedlists.LinkedListHelper.Node;

public class Intersection {
	static Node l1 = LinkedListHelper.makeLL(6);
	static Node l2 = LinkedListHelper.makeLL(9);

	public static void main(String[] args) {
		int len1 = LinkedListHelper.countLL(l1);
		int len2 = LinkedListHelper.countLL(l2);
		System.out.println(intesectData(l1, l2));
		boolean flag = false;
		if (len1 == len2) {
			while (l1.next != null) {
				if (l1 == l2) {
					flag = true;
					break;
				}
				l1 = l1.next;
				l2 = l2.next;
			}
		} else if (len1 > len2) {
			System.out.println(intersect(l1, l2, len1, len2));
			return;
		} else {
			System.out.println(intersect(l2, l1, len2, len1));
			return;
		}
		System.out.println(flag);
	}

	private static int intesectData(Node l1, Node l2) {
		Node cur1 = l1;
		Node cur2 = l2;
		while (cur1 != cur2) {
			if (cur1.next == null) {
				cur1.next = l2;
			} else {
				cur1 = cur1.next;
			}

			if (cur2.next == null) {
				cur2.next = l1;
			} else {
				cur2 = cur2.next;
			}
		}
		return cur2.data;
	}

	public static boolean intersect(Node first, Node second, int len1, int len2) {
		Node cur = first;
		for (int i = 0; i < len1 - len2; i++) {
			cur = cur.next;
		}
		while (second.next != null) {
			if (second == cur) {
				return true;
			}
			second = second.next;
			cur = cur.next;
		}
		return false;
	}
}
