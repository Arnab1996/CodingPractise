package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Scanner;

public final class Solution {

	static int MODULO = 1000000007;

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int t = scanner.nextInt();
		while (t-- > 0) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			long p = powMod(n) - 1;
			long q = powMod(m - 1) - 1;
			System.out.println((p + q + (p * q) % MODULO) % MODULO);
		}
		scanner.close();
		System.gc();
	}

	public static long powMod(long n) {
		long ret = 1;
		long a = 2;
		while (n > 0) {
			if ((n & 1) == 1)
				ret = ret * a % MODULO;
			a = a * a % MODULO;
			n >>= 1;
		}
		return ret;
	}

	public static int binarySearch(int arrayOfElements[]) {
		int leftIndex = 0, rightIndex = arrayOfElements.length - 1;
		int midElement = 0;
		while (leftIndex < rightIndex + 1) {
			midElement = (leftIndex + rightIndex) / 2;
			if (arrayOfElements[leftIndex] - leftIndex != arrayOfElements[midElement] - midElement) {
				rightIndex = midElement;
			} else if (arrayOfElements[rightIndex] - rightIndex != arrayOfElements[midElement] - midElement) {
				leftIndex = midElement;
			}
			return arrayOfElements[midElement] + 1;
		}
		return -1;
	}

	public static int flipBit(int number, int k) {
		System.out.println("Number in binary: " + Integer.toBinaryString(number));
		System.out.println("1 << k-1 in binary: " + Integer.toBinaryString(1 << k - 1));
		return number ^ (1 << k - 1);

	}

}
