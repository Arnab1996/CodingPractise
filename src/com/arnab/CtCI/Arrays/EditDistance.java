package com.arnab.CtCI.Arrays;

import java.io.InputStreamReader;
import java.util.Scanner;

public class EditDistance {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		System.out.println(editDistanceSpaceOptimized(str1, str2, str1.length(), str2.length()));
		System.out.println(oneAway(str1, str2));
		scanner.close();
	}

	public static boolean oneAway(String a, String b) {
		if (a == null || a.isEmpty())
			return b == null || b.length() == 1;
		if (b == null || b.isEmpty())
			return a == null || a.length() == 1;

		if (a.length() > b.length())
			return oneAway(b, a);// make sure a is always shorter than b

		int i = 0;
		int j = 0;
		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) != b.charAt(j)) {
				/**
				 * a is the shorter one, when we found there's a char that is different between
				 * a and b, the only two possibilities that these two strings are one edit away
				 * is these two cases: 1. a.substring(i+1).equals(b.substring(j+1)) 2.
				 * a.substring(i).equals(b.substring(j+1))
				 */
				return a.substring(i + 1).equals(b.substring(j + 1)) || a.substring(i).equals(b.substring(j + 1));
			}
			i++;
			j++;
		}
		/**
		 * When jump out of the for loop, there should be only one char left in the
		 * longer string b, otherwise return false.
		 */
		return b.length() - j == 1;

	}

	public static int editDistance(String str1, String str2, int n, int m) {
		int[][] mem = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0) {
					mem[i][j] = j;
				} else if (j == 0) {
					mem[i][j] = i;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					mem[i][j] = mem[i - 1][j - 1];
				} else {
					mem[i][j] = 1 + Math.min(mem[i - 1][j], Math.min(mem[i - 1][j - 1], mem[i][j - 1]));
				}
			}
		}
		return mem[n][m];
	}

	public static int editDistanceSpaceOptimized(String str1, String str2, int n, int m) {
		int[][] mem = new int[2][m + 1];
		for (int i = 0; i <= n; i++)
			mem[0][i] = i;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (j == 0) {
					mem[i % 2][j] = i;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					mem[i % 2][j] = mem[(i - 1) % 2][j - 1];
				} else {
					mem[i % 2][j] = 1
							+ Math.min(mem[(i - 1) % 2][j], Math.min(mem[(i - 1) % 2][j - 1], mem[i % 2][j - 1]));
				}
			}
		}
		return mem[n % 2][m];
	}
}
