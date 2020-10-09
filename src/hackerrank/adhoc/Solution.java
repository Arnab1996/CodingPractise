package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public final class Solution {

	// Input: [-35, 0, -5, -12, 94, 7, 12, 32, 9, 51] - unique numbers
	// Closest numbers: |7 - 9|
	// Output: 2

	// Corner cases: size 0 & size 1 -> return -1
	// size 2 -> Math.abs(arr[0] - arr[1])

	int printMinDiff(int arr[]) {

		int n = arr.length;
		if (n <= 1)
			return -1;
		if (n == 2) {
			return Math.abs(arr[1] - arr[0]);
		}

		// Step 1 --> Finding the pair with min diff
		Arrays.sort(arr);
		int minDiff = arr[1] - arr[0];
		for (int i = 1; i < n; i++) {
			minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
		}

		// Step 2 --> Printing out the pair
		for (int i = 1; i < n; i++) {
			if (arr[i] - arr[i - 1] == minDiff) {
				System.out.println(arr[i - 1] + " " + arr[i]);
			}
		}
		return minDiff;

	}

	static int MODULO = 1000000007;

	static class Pair {
		int val, count;

		public Pair(int val, int count) {
			this.val = val;
			this.count = count;
		}

	}

// Complete the poisonousPlants function below.
	static int poisonousPlants(int[] p) {
		Stack<Pair> stack = new Stack<>();
		int cnt = 0;
		for (int i = p.length - 1; i >= 0; i--) {
			int temp = 0;
			while (!stack.empty() && p[i] < stack.peek().val) {
				temp++;
				Pair pair = stack.pop();
				temp = Math.max(temp, pair.count);
			}
			cnt = Math.max(cnt, temp);
			stack.push(new Pair(p[i], temp));
		}

		return cnt;
	}

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		
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
