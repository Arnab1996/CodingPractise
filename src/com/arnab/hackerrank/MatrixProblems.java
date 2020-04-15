package com.arnab.hackerrank;

import java.io.InputStreamReader;
import java.util.Scanner;

interface PerformOperation {
	boolean check(int a);
}

public class MatrixProblems {

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int p = scanner.nextInt();
		int[][] pathArray = new int[m][n];
		while (p-- > 0) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			pathArray[x - 1][y - 1] = -1;
		}
		if (pathArray[1][1] == -1) {
			System.out.println("0");
			scanner.close();
			return;
		}
		for (int i = 1; i < m; i++) {
			if (pathArray[i][1] == 0)
				pathArray[i][1] = 1;
			else
				break;
		}
		for (int i = 2; i < n; i++) {
			if (pathArray[1][i] == 0)
				pathArray[1][i] = 1;
			else
				break;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (pathArray[i][j] == -1)
					continue;
				if (pathArray[i - 1][j] > 0)
					pathArray[i - 1][j] = (pathArray[i][j] + pathArray[i - 1][j]);
				if (pathArray[i][j - 1] > 0)
					pathArray[i][j - 1] = (pathArray[i][j] + pathArray[i][j - 1]);
			}
		}
		/*
		 * for (int i = 0; i < m; i++) { for (int j = 0; j < n; j++) {
		 * System.out.print(pathArray[i][j] + "  "); } System.out.println(); }
		 */
		if (pathArray[m - 2][n - 2] >= 0)
			System.out.println(pathArray[m - 2][n - 2]);
		else
			System.out.println("0");

		/*
		 * while (testCases-- > 0) { int N = scanner.nextInt(); int[] array =
		 * IntStream.range(0, N).map(i -> scanner.nextInt()).toArray(); }
		 */

		scanner.close();
	}

	public static PerformOperation is_odd() {
		return (int a) -> a % 2 != 0;
	}

	public static PerformOperation is_prime() {
		return (int a) -> java.math.BigInteger.valueOf(a).isProbablePrime(1);
	}

	public static PerformOperation is_palindrome() {
		return (int a) -> Integer.toString(a).equals(new StringBuilder(Integer.toString(a)).reverse().toString());
	}

}
