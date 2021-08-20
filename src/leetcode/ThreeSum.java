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

		List<List<Integer>> results = new LinkedList<List<Integer>>();
		int len = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < len; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			List<int[]> arr = twoSum(Arrays.copyOfRange(nums, i + 1, len), -nums[i]);
			if (arr != null) {
				for (int[] a : arr) {
					List<Integer> result = new LinkedList<>();
					result.add(nums[i]);
					result.add(a[0]);
					result.add(a[1]);
					if (!results.contains(result)) {
						results.add(result);
					}
				}
			}
		}
		return results;

	}

	public static List<int[]> twoSum(int[] numbers, int target) {
		List<int[]> results = new LinkedList<int[]>();
		int begin = 0;
		int end = numbers.length - 1;

		while (begin < end) {
			if (numbers[begin] + numbers[end] == target) {
				int toReturn[] = { numbers[begin], numbers[end] };
				results.add(toReturn);
				begin++;
				end--;
			} else if (numbers[begin] + numbers[end] > target) {
				end--;
			} else {
				begin++;
			}
		}
		return results;
	}

}
