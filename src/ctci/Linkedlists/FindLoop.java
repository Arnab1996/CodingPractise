package ctci.Linkedlists;

import ctci.Linkedlists.LinkedListHelper.Node;

public class FindLoop {
	static Node first = LinkedListHelper.makeLL(6);
	static Node second = LinkedListHelper.makeLL(10);

	public static void main(String[] args) {
		System.out.println(loop(first, second));
		System.gc();
	}

	public static boolean loop(Node first, Node second) {
		while (first != null && second != null && second.next != null) {
			first = first.next;
			second = second.next.next;
			if (first == second) {
				return true;
			}
		}
		return false;
	}
}
