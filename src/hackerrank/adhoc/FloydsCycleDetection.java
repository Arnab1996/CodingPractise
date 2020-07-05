package hackerrank.adhoc;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FloydsCycleDetection {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int n = scanner.nextInt();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < n + 1; i++) {
			nums.add(rand.nextInt(n));
		}
		for (Integer i : nums) {
			System.out.print(i + " ");
		}
		System.out.println("\n" + findDuplicate(nums));
		scanner.close();
		System.gc();
	}

	static int findDuplicate(ArrayList<Integer> nums) {
		int count = 0;
		if (nums.size() < 1) {
			return -1;
		}
		int slow = nums.get(0);
		int fast = nums.get(nums.get(0));
		while (slow != fast) {
			slow = nums.get(slow);
			fast = nums.get(nums.get(fast));
			count++;
		}
		fast = 0;
		while (slow != fast) {
			slow = nums.get(slow);
			fast = nums.get(fast);
			count++;
		}
		System.out.println("\nCount is : " + count);
		return slow;
	}
}
