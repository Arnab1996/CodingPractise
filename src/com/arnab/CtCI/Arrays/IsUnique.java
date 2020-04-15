package com.arnab.CtCI.Arrays;

import java.io.InputStreamReader;
import java.util.Scanner;

public class IsUnique {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String input = scanner.nextLine();
		String lowerInput = input.toLowerCase();
		int length = lowerInput.length();
		int checker = 0;
		boolean flag = true;
		for (int i = 0; i < length; i++) {
			int val = lowerInput.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				flag = false;
				System.out.println("NO");
			}
			checker |= (1 << val);
		}
		if (flag)
			System.out.println("YES");
		scanner.close();

	}
}
