import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test_Adobe {

	static int fact(int k) {
		if (k == 0 || k == 1)
			return 1;
		return k * fact(k - 1);
	}

	static int factTail(int k, int mul) {
		if (k == 0 || k == 1)
			return mul;
		return factTail(k - 1, k * mul);
	}

	/*
	 * To compute sqrt(x):
	 * 
	 * ▶ Start with an initial estimate y (let’s pick y = 1).
	 * 
	 * ▶ Repeatedly improve the estimate by taking the mean of y and x/y.
	 */

	static double delta = 0.00000005;

	static double sqrt(double x) {
		double y = 1;
		while (true) {
			if (x == delta) {
				y = x / 2;
			}
			if (Math.abs(x - y * y) <= delta) {
				return y;
			}
			y = (y + x / y) / 2.0;
		}
	}

	/*
	 * Problem statement: when we insert batch of records into mysql with MySQL
	 * transaction then whole batch gets rolled back in case of any exception. write
	 * a method to break the impacted batch of records into two when a function
	 * returns an error, and retries them separately. This allows you to easily
	 * separate the malformed data record from the rest of the batch, and process
	 * the rest of data records successfully.
	 * 
	 * inputParam: list of Objects to be inserted into DB
	 * 
	 * returns: list of objects failed to be inserted( malformed data records)
	 * 
	 * Pseudo code:
	 * 
	 * count = size of input list 2 lists of half elements, partitioned by count/2
	 * 
	 * global error list -> start empty
	 * 
	 * Code:
	 */

	static List<Integer> inputParamListError = new ArrayList<Integer>();

	public static List<Integer> doRetryWithBisectionOnError(List<Integer> inputParamList) {
		int count = inputParamList.size();
		if (count == 1) {
			return inputParamListError;
		}
		if (Boolean.FALSE.equals(saveToDB(inputParamList))) {
			inputParamListError.addAll(inputParamList);
		} else {
			return inputParamListError;
		}

		List<Integer> inputParamListFirst = new ArrayList<Integer>();
		List<Integer> inputParamListSecond = new ArrayList<Integer>();
		int i = 0;
		for (i = 0; i < count / 2; i++) {
			inputParamListFirst.add(inputParamList.get(i));
		}
		for (; i < count; i++) {
			inputParamListSecond.add(inputParamList.get(i));
		}
		doRetryWithBisectionOnError(inputParamListFirst);
		return doRetryWithBisectionOnError(inputParamListSecond);

	}

	// Takes 'inputParamList' as input param and saves it DB with MySQL transaction
	public static boolean saveToDB(List<Integer> inputParamList) {
		Random random = new Random();
		// Successfully saved whole batch(inputParamList) to DB)
		if (random.nextInt(1) == 1)
			return true;
		else
			return false;
	}

	/*
	 * Convert BST to Circular Doubly Sorted Linked List
	 * 
	 * inherently sorted in inorder traversal
	 * 
	 * Use of recursion - left and right subtrees
	 * 
	 * left subtree to CDLL - leftList right subtree to CDLL - rightList
	 * 
	 * tail.next -> head head.prev -> tail node of
	 * 
	 * root of BST => prev and next point to itself
	 * 
	 * leftList + root
	 * 
	 * rightList + above list
	 * 
	 */

	class Node {
		int val;
		Node left, right;

		Node(int val) {
			this.val = val;
			left = right = null;
		}
	}

	// input is root node of bst
	// output is cdll node

	Node bst2cdll(Node root) {
		if (root == null)
			return null;

		// converting left and right subtrees
		Node left = bst2cdll(root.left);
		Node right = bst2cdll(root.right);

		// make the single node circular
		root.left = root.right = root;

		// left list + root
		// above list + right
		return concate(concate(left, root), right);
	}

	// input 2 cdll
	// output 1 cdll
	Node concate(Node left, Node right) {
		if (left == null)
			return right;
		if (right == null)
			return left;
		Node lastOfLeft = left.left;
		Node lastOfRight = right.left;

		// Connecting them
		lastOfLeft.right = right;
		right.left = lastOfLeft;
		left.left = lastOfRight;
		lastOfRight.right = left;
		return left;
	}

	void display(Node head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.left;
		}
	}

	/**
	 * 5
	 * 
	 * 2 12
	 * 
	 * 1 10 15
	 * 
	 * 
	 * 
	 * top => {1 -> 2} 5 => 1 -> 2 -> 5 + {10->12->15} => 1 -> 2 -> 5 + 10 -> 12 ->
	 * 15
	 * 
	 * 
	 * 
	 * left => 1 -> 2
	 * 
	 * 
	 * 
	 * right => {10 -> 12} 15 => 10 -> 12 -> 15 right.left => 10 -> 12
	 * 
	 * 
	 */

	/**
	 * Array with sorted interger, rotated Start of the original array Use Binary
	 * Search T: O(log n) mid = hi + lo /2 arr[lo] <= arr[mid] => lo ->> mid is
	 * sorted
	 * 
	 */

	static int findMin(int[] arr) {
		int size = arr.length;
		if (size == 0)
			return -1;

		if (size == 1 || arr[0] < arr[size - 1])
			return 0;

		int lo = 0, hi = size - 1;
		while (lo <= hi) {
			int mid = (hi + lo) / 2;
			if (mid < size - 1 && arr[mid] > arr[mid + 1]) {
				return mid + 1;
			} else if (mid > lo && arr[mid] < arr[mid - 1]) {
				return mid;
			} else if (arr[lo] <= arr[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(fact(5));
		System.out.println(fact(7));
		System.out.println(factTail(5, 1));
		System.out.println(factTail(7, 1));

		System.out.println(sqrt(0.00000005));
		System.out.println(sqrt(0.000005));
		System.out.println(sqrt(0.0000000005));
		System.out.println("\n");

		int arr1[] = { 5, 6, 7, 1, 2, 3, 4 };
		System.out.println(findMin(arr1));
	}

}
