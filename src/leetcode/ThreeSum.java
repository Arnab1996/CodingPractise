package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		ThreeSum sum = new ThreeSum();
		System.out.println(sum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		if (len < 3)
			return results;

		Arrays.sort(nums);

		for (int i = 0; i < len - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int j = i + 1, k = len - 1;
				while (j < k) {
					int sum = nums[i] + nums[j] + nums[k];
					if (sum == 0) {
						List<Integer> result = new LinkedList<Integer>();
						result.add(nums[i]);
						result.add(nums[j]);
						result.add(nums[k]);
						results.add(result);
						while (j < k && nums[j] == nums[j + 1])
							j++;
						while (j < k && nums[k] == nums[k - 1])
							k--;
						j++;
						k--;
					} else if (sum > 0)
						k--;
					else
						j++;
				}
			}
		}
		return results;
	}
}
