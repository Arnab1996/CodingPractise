package ctci.Arrays;

import java.io.InputStreamReader;
import java.util.Scanner;

public class IsPermutation {
	static int[] char_set = new int[256];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();
		if (s1.length() != s2.length()) {
			System.out.println("NO");
		}
		for (int i = 0; i < s1.length(); i++) {
			char_set[s1.charAt(i)]++;
		}
		for (int i = 0; i < s2.length(); i++) {
			char_set[s2.charAt(i)]--;
		}
		boolean flag = true;
		for (int i = 0; i < 256; i++) {
			if (char_set[i] != 0) {
				flag = false;
				System.out.println("NO");
				break;
			}
		}
		if (flag)
			System.out.println("YES");
		scanner.close();
	}
}
