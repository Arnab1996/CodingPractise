package com.arnab.CtCI.Arrays;

import java.io.InputStreamReader;
import java.util.Scanner;

public class StringCompression {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String str = scanner.nextLine();
		System.out.println(aZCompress(str));
		scanner.close();
	}

	public static String aZCompress(String str) {
		int len = str.length();
		if (len == 0)
			return str;
		int count = 1;
		char prev = str.charAt(0);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < len; i++) {
			if (prev == str.charAt(i)) {
				count++;
			} else {
				sb.append(prev);
				sb.append(count);
				count = 1;
			}
			prev = str.charAt(i);
		}
		sb.append(prev);
		sb.append(String.valueOf(count));
		if (sb.toString().length() <= len) {
			return sb.toString();
		}
		return str;

	}
}
