package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Scanner;

public class SumOfFibonacci {
	static long[] f = new long[100000];

	// Returns n'th Fibonacci number using table f[]
	public static long fib(long n) {
		// Base cases
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return (f[(int) n] = 1);
		}

		// If fib(n) is already computed
		if (f[(int) n] > 0) {
			return f[(int) n];
		}

		long k = ((n & 1) > 0) ? (n + 1) / 2 : n / 2;

		// Applying above formula [Note value n&1 is 1
		// if n is odd, else 0].
		f[(int) n] = (((n & 1) > 0) ? (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) : (2 * fib(k - 1) + fib(k)) * fib(k));

		return f[(int) n];
	}

	// Function to calculate sum of
	// squares of Fibonacci numbers
	public static long calculateSumOfSquares(long n) {
		return (fib(n) % 1000000007 * fib(n + 1) % 1000000007) % 1000000007;
	}

	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int t = scanner.nextInt();
		while (t-- > 0) {
			System.out.println(calculateSumOfSquares(scanner.nextLong()));
		}
		scanner.close();
	}
}
