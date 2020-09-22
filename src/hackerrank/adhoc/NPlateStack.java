package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class NPlateStack {

	private static Stack<Integer> data;
	private static Stack<Integer> div_stack;
	private static Stack<Integer> non_div_stack;

	public NPlateStack(int[] raw_data) {
		data = new Stack<Integer>();
		div_stack = new Stack<Integer>();
		non_div_stack = new Stack<Integer>();
		for (int i = 0; i < raw_data.length; i++)
			data.push(raw_data[i]);
	}

	@SuppressWarnings("unchecked")
	public void process_division(int Q) {
		int iter_num = Q;
		int curNum, prime = 2;
		while (iter_num-- > 0) {
			non_div_stack.clear();
			while (!data.isEmpty()) {
				curNum = data.pop();
				if (curNum % prime == 0)
					div_stack.push(curNum);
				else
					non_div_stack.push(curNum);
			}
			prime = next_prime(prime);
			print_divisible();
			data = (Stack<Integer>) non_div_stack.clone();
		}
		while (!non_div_stack.isEmpty())
			System.out.println(non_div_stack.pop() + "");
	}

	private int next_prime(int current_prime) {
		int prime = current_prime;
		boolean isPrime = false;
		while (!isPrime) {
			prime++;
			isPrime = true;
			for (int i = 2; i < prime; i++) {
				if (prime % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		return prime;
	}

	private void print_divisible() {
		while (!div_stack.isEmpty()) {
			System.out.println(div_stack.pop() + "");
		}
	}

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int N = scanner.nextInt();
		int Q = scanner.nextInt();
		int[] data = new int[N];
		for (int i = 0; i < N; i++)
			data[i] = scanner.nextInt();
		NPlateStack solution = new NPlateStack(data);
		solution.process_division(Q);
		scanner.close();
		System.gc();
	}
}