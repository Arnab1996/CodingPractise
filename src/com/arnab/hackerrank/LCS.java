package com.arnab.hackerrank;

import java.io.InputStreamReader;
import java.util.Scanner;

public class LCS {
	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String S = "AOCMDOCMDOCSAMDO";
		String T = "AONAZONAZMAZONAZ";
		long start1 = System.nanoTime();
		System.out.println(lcs(S.toCharArray(), T.toCharArray(), S.length(), T.length()));
		System.out.println(System.nanoTime() - start1);
		long start2 = System.nanoTime();
		System.out.println(LCS_Util(S.toCharArray(), T.toCharArray(), S.length(), T.length()));
		System.out.println(System.nanoTime() - start2);
		System.gc();
		scanner.close();
	}

	public static int lcs(char[] S, char[] T, int n, int m) {
		int[][] mem = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			mem[i][0] = 0;
		}
		for (int i = 0; i <= m; i++) {
			mem[0][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (S[i - 1] == T[j - 1]) {
					mem[i][j] = mem[i - 1][j - 1] + 1;
				} else {
					mem[i][j] = Math.max(mem[i][j - 1], mem[i - 1][j]);
				}
			}
		}

		return mem[n][m];
	}

	public static int LCS_Util(char[] S, char[] T, int n, int m) {
		if (n == 0 || m == 0) {
			return 0;
		}
		if (S[n - 1] == T[m - 1]) {
			return 1 + LCS_Util(S, T, n - 1, m - 1);
		} else {
			return Math.max(LCS_Util(S, T, n, m - 1), LCS_Util(S, T, n - 1, m));
		}
	}
}
