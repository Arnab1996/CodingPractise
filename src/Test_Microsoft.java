import java.util.*;

public class Test_Microsoft {

	////////////////////// Round 1 //////////////////////////////

	// Node structure
	static class Node {
		int data;
		Node next;
		boolean visited;

		Node(int d) {
			data = d;
			next = null;
			visited = false;
		}
	}

	static Node head1, head2;

	// Get length function.
	// Input: head of linked list
	// Output: Length of the linked list
	static int getLength(Node node) {
		if (node == null)
			return 0;
		Node current = node;
		int len = 0;
		while (current != null) {
			if (current.visited)
				break;
			System.out.println(current.data);
			len++;
			current.visited = true;
			current = current.next;
		}
		System.out.println("Length of node " + node.data + " is " + len);
		return len;

	}

	// Get Node
	// Main function
	static int getNode() {
		int l1 = getLength(head1); // 8
		int l2 = getLength(head2); // 5
		int d = Math.abs(l1 - l2); // 3
		if (l1 > l2) {
			return getIntersection(d, head1, head2); // here // return 4
		} else {
			return getIntersection(d, head2, head1);
		}
	}

	static int getIntersection(int d, Node node1, Node node2) {
		Node current1 = node1;
		Node current2 = node2;
		for (int i = 0; i < d; i++) {
			if (current1 == null) {
				return -1;
			}
			current1 = current1.next; // current1 = 4
		}

		while (current1 != null && current2 != null) { // run 1 times
			if (current1 == current2) { // current1 = current2 = 4
				return current1.data; // 4
			}
			current1 = current1.next;
			current2 = current2.next;
		}
		return -1;
	}

	// get intersection utility
	// Output: -1 for no intersection, int value of node for intersection
	static int getIntersection2(Node node1, Node node2) {
		Node current1 = node1;
		Node current2 = node2;

		while (current1 != null) {
			if (current1.visited)
				break;
			current1.visited = true;
			current1 = current1.next;
		}

		while (current2 != null) {
			if (current2.visited) {
				return current2.data;
			}
			current2.visited = true;
			current2 = current2.next;
		}

		return -1;
	}

	////////////////////// Round 1 End //////////////////////////////

	////////////////////// Round 2 //////////////////////////////

	// Structure of the tree Node
	static class TreeNode {
		int data;
		TreeNode right;
		TreeNode left;
		TreeNode prev;

		TreeNode(int data) {
			this.data = data;
			left = right = prev = null;
		}
	}

	// reference to the Root of the tree
	static TreeNode root;

	// Level order traversing
	static void getLevelOrder(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> Q = new LinkedList<>();
		Q.add(root);
		TreeNode temp = null;

		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				TreeNode prev = temp;
				temp = Q.poll(); // temp = 2
				if (i > 0) { // i = 0
					prev.prev = temp;
				}
				if (temp.right != null) {
					Q.add(temp.right);
				}
				if (temp.left != null) {
					Q.add(temp.left);
				}
			}
			temp.prev = null;
		}
	}

	////////////////////// Round 2 //////////////////////////////

	static class CityPairs // Create user-defined class
	{
		int north, south;

		CityPairs(int north, int south) // Constructor
		{
			this.north = north;
			this.south = south;
		}
	}

	// Use Comparator for manual sorting
	static class MyCmp implements Comparator<CityPairs> {
		public int compare(CityPairs cp1, CityPairs cp2) {
			// If 2 cities have same north coordinates
			// then sort them in increasing order
			// according to south coordinates.
			if (cp1.north == cp2.north)
				return cp1.south - cp2.south;

			// Sort in increasing order of
			// north coordinates.
			return cp1.north - cp2.north;
		}
	}

	// function to find the max. number of bridges
	// that can be built
	public static int maxBridges(CityPairs[] pairs, int n) {
		int[] LIS = new int[n];
		// By default single city has LIS = 1.
		Arrays.fill(LIS, 1);

		Arrays.sort(pairs, new MyCmp()); // Sorting->
											// calling
		// our self made comparator

		// Logic for Longest increasing subsequence
		// applied on south coordinates.
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (pairs[i].south >= pairs[j].south)
					LIS[i] = Math.max(LIS[i], LIS[j] + 1);
			}
		}
		int max = LIS[0];
		for (int i = 1; i < n; i++) {
			max = Math.max(max, LIS[i]);
		}

		// Return the max number of bridges that can be
		// built.
		return max;
	}

	////////////////////// Round 2 End //////////////////////////////

	////////////////////// Round 3 //////////////////////////////

	static Stack<Object> stack2 = new Stack<>();

	// To validate the string
	static boolean isValid(String expr) {
		// ^ to 1st operator - all numbers
		// last operator to $ all numbers
		// from 1 operator to next operator - all numbers
		
		expr = expr.replaceAll(" ", "");

		Stack<Object> stack1 = new Stack<>();
		for (int i = expr.length() - 1; i >= 0; i--) {
			if (isNumber(expr.charAt(i))) {
				stack1.push(value(expr.charAt(i)));
			} else if (isOperand(expr.charAt(i))) {
				long number = 0;
				int radix = 0;
				while (stack1.isEmpty()) {
					number += (long) (Math.pow(10, radix) * value((char)stack1.pop()));
					radix++;
				}
				stack2.push(number);
				stack2.push(expr.charAt(i));
			}
		}
		return stack1.isEmpty();
	}

	// Function to return whether it is operator
	static boolean isOperand(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
			return true;
		}
		return false;
	}

	// Function to return whether it is number
	static boolean isNumber(char c) {
		// return (c >= '0' && c<= '9');
		return Character.isDigit(c);
	}

	// Function to convert char to int value
	static int value(char c) {
		return (c - '0');
	}

	// Function to evaluate
	// Base case: empty string -> return -1
	static int evaluate(String expr) {
		int len = expr.length();
		if (len == 0) {
			return -1;
		}
		int result = 0;
		if (isNumber(expr.charAt(0))) {
			result = value(expr.charAt(0));
			for (int i = 1; i < len; i = i + 2) {
				char operator = expr.charAt(i);
				char number = expr.charAt(i + 1);
				if (!isNumber(number))
					return -1;

				if (operator == '+')
					result += value(number);

				else if (operator == '-')
					result -= value(number);

				else if (operator == '*')
					result *= value(number);

				else if (operator == '/' && value(number) != 0)
					result /= value(number);

				else
					return -1;
			}
		}
		return result;
	}

	////////////////////// Round 3 End //////////////////////////////

	public static void main(String[] args) {

		head1 = new Node(1);
		head2 = new Node(12);

		Node curr1 = head1;
		Node curr2 = head2;

		Node commonNode = new Node(4);

		curr1.next = new Node(2);
		curr1.next.next = new Node(3);
		curr1.next.next.next = commonNode;
		curr1.next.next.next.next = new Node(5);
		curr1.next.next.next.next.next = new Node(9);
		curr1.next.next.next.next.next.next = new Node(7);
		curr1.next.next.next.next.next.next.next = new Node(0);
		curr1.next.next.next.next.next.next.next.next = head1.next.next;
		curr2.next = new Node(12);
		curr2.next.next = commonNode;

		System.out.println(getIntersection2(head1, head2));

		int n = 4;
		CityPairs[] pairs = new CityPairs[n];
		pairs[0] = new CityPairs(6, 2);
		pairs[1] = new CityPairs(4, 3);
		pairs[2] = new CityPairs(2, 6);
		pairs[3] = new CityPairs(1, 5);
		System.out.println("Maximum number of bridges = " + maxBridges(pairs, n));

	}
}
