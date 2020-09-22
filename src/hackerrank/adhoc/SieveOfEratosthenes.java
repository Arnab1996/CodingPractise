package hackerrank.adhoc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SieveOfEratosthenes {

	static boolean isPrime(long n) {
		if (n == 1) {
			return false;
		}
		for (long i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean[] markerArray = new boolean[10000001];
	static ArrayList<Long> primes = new ArrayList<>();

	public static void sieve() {

		markerArray[0] = markerArray[1] = true;

		for (long i = 2; i * i <= 10000000; i++) {
			if (!markerArray[(int) i]) {
				for (long j = i * i; j <= 10000000; j += i) {
					markerArray[(int) j] = true;
				}
			}
		}

		for (long i = 0; i <= 10000000; i++) {
			if (!markerArray[(int) i]) {
				primes.add(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		sieve();
		/*
		 * long q = scanner.nextLong(); while (q-- > 0) {
		 * System.out.println(primes.get(scanner.nextInt())); }
		 */
		for (int i = 1; i <= 1200; i++) {
			System.out.print(primes.get(i) + ",");
		}

		scanner.close();
	}
}
