package leetcode;

import java.util.LinkedList;
import java.util.List;

public class MissingRanges {
	public static void main(String[] args) {
		MissingRanges missingRanges = new MissingRanges();
		System.out.println(missingRanges.findMissingRanges(new int[] { 0, 1, 3, 50, 75 }, 0, 99));
	}

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new LinkedList<>();

		if (lower > upper)
			return res;

		if (nums == null || nums.length == 0) {
			if (lower == upper)
				res.add(lower + "");
			else
				res.add(lower + "->" + upper);
			return res;
		}

		int low = lower;
		int up = upper;
		boolean overflow = false;
		for (int i = 0; i < nums.length; i++) {
			if (low < nums[i]) {
				res.add(getRange(low, nums[i] - 1));
			}
			low = nums[i] + 1;
			if (low == Integer.MIN_VALUE) {
				overflow = true;
				break;
			}
		}
		if (low <= up && overflow == false) {
			res.add(getRange(low, up));
		}
		return res;
	}

	private String getRange(int a, int b) {
		if (a == b) {
			return a + "";
		} else {
			return a + "->" + b;
		}
	}

}
