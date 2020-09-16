package leetcode;

import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

/*
    Given an unsorted integer array, find the smallest missing positive integer.

	Example 1:
	
	Input: [1,2,0]
	Output: 3
	Example 2:
	
	Input: [3,4,-1,1]
	Output: 2
	Example 3:
	
	Input: [7,8,9,11,12]
	Output: 1
	Follow up:
	
	Your algorithm should run in O(n) time and uses constant extra space.
 */

public class FindLowestMissingPositive {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int[] input = new int[] { 7, 8, 9, 11, 12 };
		System.out.println(firstMissingPositive(input));
		scanner.close();
		System.gc();
	}

	public static int firstMissingPositive(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			set.add(i);
		}
		for (int i = 1; i < 100000;) {
			if (set.contains(i))
				i++;
			else
				return i;

		}
		return -1;
	}

}
