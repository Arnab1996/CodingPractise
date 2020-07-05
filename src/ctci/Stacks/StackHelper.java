package ctci.Stacks;

import java.util.Random;

public class StackHelper {
	public static MyStack<Integer> makeStack(int len) {
		Random random = new Random();
		MyStack<Integer> stack = new MyStack<Integer>();
		for (int i = 0; i < len; i++) {
			stack.push(random.nextInt(100));
		}
		System.out.println();
		stack.init();
		return stack;
	}

	public static void printStack(MyStack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
			System.out.println();
		}
	}
}
