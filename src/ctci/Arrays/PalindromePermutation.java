package ctci.Arrays;

import java.io.InputStreamReader;
import java.util.Scanner;

public class PalindromePermutation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String str = scanner.nextLine();
		int length = str.length();
		if (length % 2 == 0) {
			System.out.println(checkerEven(str, length / 2));
		} else {
			System.out.println(checkerOdd(str, (length - 1) / 2));
		}
		scanner.close();
	}

	static int[] charSet = new int[256];

	public static boolean checkerEven(String str, int n) {
		for (int i = 0; i < str.length(); i++) {
			charSet[str.charAt(i) - 'a']++;
		}
		int counter = 0;
		for (int i = 0; i < 256; i++) {
			if (charSet[i] == 2) {
				counter++;
			}
		}
		return counter == n;
	}

	public static boolean checkerOdd(String str, int n) {
		for (int i = 0; i < str.length(); i++) {
			charSet[str.charAt(i) - 'a']++;
		}
		int counter = 0, counter1 = 0;
		for (int i = 0; i < 256; i++) {
			if (charSet[i] == 2) {
				counter++;
			}
			if (charSet[i] == 1) {
				counter1++;
			}
		}
		return counter == n && counter1 == 1;
	}
}
