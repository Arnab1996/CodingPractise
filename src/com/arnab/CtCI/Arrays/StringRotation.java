package com.arnab.CtCI.Arrays;

import java.io.InputStreamReader;
import java.util.Scanner;

public class StringRotation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		str1 = str1 + str1;
		System.out.println(str1.contains(str2));
		scanner.close();
	}
}
