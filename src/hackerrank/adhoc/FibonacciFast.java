package hackerrank.adhoc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciFast {
	static long modulo = 100000000000000007L;
	static Map<Long, Long> fibonacci = new HashMap<Long, Long>();

	public static long fib(long n) {
		if (fibonacci.containsKey(n)) {
			return fibonacci.get(n);
		}
		long k = n / 2;
		if (n % 2 == 0) {
			fibonacci.put(n, (fib(k) % modulo * fib(k) % modulo + fib(k - 1) % modulo * fib(k - 1) % modulo) % modulo);
			return fibonacci.get(n);
		} else {
			fibonacci.put(n, (fib(k) % modulo * fib(k + 1) % modulo + fib(k - 1) % modulo * fib(k) % modulo) % modulo);
			return fibonacci.get(n);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		System.out.println("Enter the number of elements you want:");
		long numerOfTestCases;
		fibonacci.put(0L, 1L);
		fibonacci.put(1L, 1L);
		numerOfTestCases = scanner.nextLong();

		for (long i = 0; i < numerOfTestCases; i++) {
			System.out.print((i == 0 ? 0 : fib(i - 1)) + " ");
		}

		scanner.close();
		System.gc();

	}

}
