package ctci.Stacks;

import java.util.Random;
import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> stackToSort = new Stack<>();
		Random random = new Random();
		for (int i = 0; i < 7; i++) {
			stackToSort.push(random.nextInt(30));
		}
		System.out.println("Original Stack " + stackToSort);
		System.out.println("Sorted Stack " + mergeSort(stackToSort, 7));
		System.gc();
	}

	public static Stack<Integer> mergeSort(Stack<Integer> stackToSort, int len) {
		if (len <= 1) {
			return stackToSort;
		}
		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		int count = 0;
		while (!stackToSort.isEmpty()) {
			count++;
			if (count % 2 == 0) {
				left.push(stackToSort.pop());
			} else {
				right.push(stackToSort.pop());
			}
		}
		left = mergeSort(left, left.size());
		right = mergeSort(right, right.size());

		while (left.size() > 0 || right.size() > 0) {
			if (left.size() == 0) {
				stackToSort.push(right.pop());
			} else if (right.size() == 0) {
				stackToSort.push(left.pop());
			} else if (right.peek().compareTo(left.peek()) <= 0) {
				stackToSort.push(left.pop());
			} else {
				stackToSort.push(right.pop());
			}
		}
		Stack<Integer> reverseSatck = new Stack<Integer>();
		while (!stackToSort.isEmpty()) {
			reverseSatck.push(stackToSort.pop());
		}
		return reverseSatck;
	}

}
