package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int Q = scanner.nextInt();
		String S = "";
		Stack<String> stack = new Stack<>();
		while (Q-- > 0) {
			switch (scanner.nextInt()) {
			case 1:
				String W = scanner.nextLine();
				stack.add(S);
				S += W;
				break;
			case 2:
				stack.add(S);
				S = S.substring(0, S.length() - scanner.nextInt());
				break;
			case 3:
				System.out.println(S.charAt(scanner.nextInt() - 1));
				break;
			case 4:
				S = stack.pop();
			}
		}

		scanner.close();
		System.gc();
	}
}
