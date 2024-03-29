package leetcode;

import java.util.Stack;

public class ValidParantheses {
	public static void main(String[] args) {
		ValidParantheses parantheses = new ValidParantheses();
		System.out.println(parantheses.isValid("(]"));
		System.out.println(parantheses.isValid("({})"));
	}

	public boolean isValid(String s) {

		if (s == null || s.length() == 0)
			return true;
		if (s.length() % 2 != 0)
			return false;

		Stack<Character> st = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[')
				st.push(c);

			if (st.isEmpty())
				return false;

			char top;
			switch (c) {
			case ')':
				top = st.pop();
				if (top == '[' || top == '{')
					return false;
				break;

			case ']':
				top = st.pop();
				if (top == '(' || top == '{')
					return false;
				break;

			case '}':
				top = st.pop();
				if (top == '[' || top == '(')
					return false;
				break;

			}
		}
		return st.isEmpty();
	}

	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
