package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public final class Solution {

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
		int n = scanner.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		System.out.println(poisonousPlants(arr));
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
