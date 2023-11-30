package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class ThreeSum {
	public static void main(String[] args) {
		ThreeSum sum = new ThreeSum();
		System.out.println(sum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		List<List<Integer>> results = new LinkedList<>();
		if (len < 3) {
            return results;
        }

		Arrays.sort(nums);

		for (int i = 0; i < len - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int j = i + 1, k = len - 1;
				while (j < k) {
					int sum = nums[i] + nums[j] + nums[k];
					if (sum == 0) {
						List<Integer> result = new LinkedList<>();
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
