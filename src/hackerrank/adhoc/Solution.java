package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.Scanner;

public final class Solution {

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int hours = 12;
		int[] arr = { 5, 2, 1, 3, 9, 5, 1, 3 };
		// int[] arr = {5, 2, 1, 3, 9, 5, 1, 3, 2, 1, 4};

		int res = maxBooks(arr, hours);
		System.out.println(res);
		scanner.close();
		System.gc();
	}

	public static int maxBooks(int[] arr, int hours) {
		int max = 0;
		int windowSum = 0;
		int l = 0;
		int r = 0;

		while (r < arr.length) {

			while (r < arr.length && windowSum <= hours) {
				windowSum += arr[r];
				r++;
				System.out.println(l + " " + (r - 1) + " " + windowSum);
				if (windowSum <= hours) {
					max = Math.max(max, r - l);
				}
			}

			while (l < r && l < arr.length && windowSum > hours) {
				windowSum -= arr[l];
				l++;
				System.out.println(l + " " + (r - 1) + " " + windowSum);
				if (windowSum <= hours) {
					max = Math.max(max, r - l);
				}
			}

		}
		return max;
	}

}
