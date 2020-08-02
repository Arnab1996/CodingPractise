package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public final class Solution {

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));

		List<Integer> list2 = new ArrayList<>();
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(list2);
		System.out.println(set.toString());

		scanner.close();
		System.gc();
	}

	public static int flipBit(int number, int k) {
		System.out.println("Number in binary: " + Integer.toBinaryString(number));
		System.out.println("1 << k-1 in binary: " + Integer.toBinaryString(1 << k - 1));
		return number ^ (1 << k - 1);
	}

}
