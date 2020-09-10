package ctci.Linkedlists;

import java.util.HashMap;

public class Oracle {

	static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}

	}

	static Node head = null;
	static Node back = null;

	static int MAX_CAPACITY = 16;
	static int size = 0;

	static int top() {
		if (head == null) {
			System.err.println("Queueu is empty");
			return 0;
		}
		return head.data;
	}

	static boolean isEmpty(Node first) {
		if (first == null) {
			return true;
		}
		return false;
	}

	static Node poll() {
		if (head == null) {
			System.err.println("Queueu is empty");
			return null;
		}
		if (head.next == null) {
			head = null;
			size--;
			return null;
		} else {
			Node newHead = head.next;
			head = null;
			head = newHead;
		}
		return head;
	}

	static Node push(int data) {
		if (size == MAX_CAPACITY) {
			System.err.println("Queueu is full");
			return null;
		}
		if (head == null) {
			head = new Node(data, null);
			back = head;
			size++;
		} else {
			Node temp = new Node(data, null);
			back.next = temp;
			back = temp;
			size++;
		}
		return head;
	}

	static void print(Node head) {
		Node cur = head;
		while (cur.next != null) {
			System.out.println(cur.data);
			cur = cur.next;
		}
		System.out.println(cur.data);
	}

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		String s1 = "AA";
		map.put(s1, "aa");
		s1 = "SS";
		System.out.println(map.get(s1)); // --> gives null
		push(3);
		push(2);
		push(5);
		push(7);
		poll();
		System.out.println(top());
		System.out.println(isEmpty(head));
		System.out.println(head);
		System.out.println(back);
		print(head);

	}

}
