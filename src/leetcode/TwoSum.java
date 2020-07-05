package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
	}

	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			Integer diff = (Integer) (target - numbers[i]);
			if (hash.containsKey(diff)) {
				int toReturn[] = { hash.get(diff) + 1, i + 1 };
				return toReturn;
			}
			hash.put(numbers[i], i);
		}
		return null;
	}
}
