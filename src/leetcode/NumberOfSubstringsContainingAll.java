package leetcode;

import java.io.InputStreamReader;
import java.util.Scanner;

public class NumberOfSubstringsContainingAll {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		System.out.println(SubString("abcabc"));
		scanner.close();
		System.gc();
	}

	public static int SubString(String s) {
		int count[] = new int[] { 0, 0, 0 };
		int res = 0, i = 0, n = s.length();
		for (int j = 0; j < n; ++j) {
			++count[s.charAt(j) - 'a'];
			while (count[0] > 0 && count[1] > 0 && count[2] > 0)
				--count[s.charAt(i++) - 'a'];
			res += i;
		}
		return res;
	}

}
