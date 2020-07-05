package ctci.Stacks;

import java.util.Stack;

public class O1MinFromStack {

	static MyStack<Integer> stack1 = StackHelper.makeStack(7);

	public static void main(String[] args) {
		Stack<Integer> stack2 = new Stack<Integer>();
		stack2.push(Integer.MAX_VALUE);
		while (!stack1.isEmpty()) {
			if (stack1.peek() < stack2.peek()) {
				stack2.push(stack1.pop());
			}
			if (!stack1.isEmpty()) {
				stack1.pop();
			}
		}
		System.out.println(stack2.peek());
		System.gc();
	}
}
