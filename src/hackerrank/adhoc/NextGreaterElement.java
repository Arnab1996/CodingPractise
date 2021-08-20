package hackerrank.adhoc;

import java.util.Stack;

/**
 * 
 * @author saarnab Method 2 (Using Stack)
 * 
 *         Push the first element to stack. Pick rest of the elements one by one
 *         and follow the following steps in loop. Mark the current element as
 *         next. If stack is not empty, compare top element of stack with next.
 *         If next is greater than the top element,Pop element from stack. next
 *         is the next greater element for the popped element. Keep popping from
 *         the stack while the popped element is smaller than next. next becomes
 *         the next greater element for all such popped elements Finally, push
 *         the next in the stack. After the loop in step 2 is over, pop all the
 *         elements from stack and print -1 as next element for them.
 *
 * 
 */

public class NextGreaterElement {
	static int[] array = new int[] { 11, 13, 21, 3 };

	public static void main(String[] args) {
		int nge[] = new int[array.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = array.length - 1; i >= 0; i--) {
			/*
			 * if stack is not empty, then pop an element from stack. If the popped element
			 * is smaller than next, then a) print the pair b) keep popping while elements
			 * are smaller and stack is not empty
			 */
			if (!stack.empty()) {
				while (!stack.empty() && stack.peek() <= array[i]) {
					stack.pop();
				}
			}
			nge[i] = stack.empty() ? -1 : stack.peek();
			stack.push(array[i]);
		}
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i] + " --> " + nge[i]);

		System.out.println(solveForEfficientCabScheduling(3, new int[] { 1, 2 }));

	}

	public static int solveForEfficientCabScheduling(int n, int[] k) {
		int l = 0, h = Integer.MAX_VALUE, m = h + (l - h) / 2;
		while (l < h) {
			m = h + (l - h) / 2;
			int trips = 0;
			for (int i : k) {
				trips += m / i;
			}
			if (trips == n) {
				break;
			} else if (trips < n) {
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return m;
	}

}
