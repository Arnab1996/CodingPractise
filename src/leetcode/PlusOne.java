package leetcode;

import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args) {
		PlusOne one = new PlusOne();
		System.out.println(Arrays.toString(one.plusOne(new int[] { 1, 2, 3 })));
	}

	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return null;
		}
		int len = digits.length;
		int results[] = new int[len + 1];
		if (len == 1) {
			if (digits[0] != 9) {
				digits[0] = digits[0] + 1;
				return digits;
			} else {
				results[0] = 0;
				results[1] = 1;
				return results;
			}
		} else {
			int carry = 0;
			results[len] = (digits[len - 1] + 1 + carry) % 10;
			carry = (digits[len - 1] + 1 + carry) / 10;
			for (int i = len - 2; i >= 0; i--) {
				results[i + 1] = (digits[i] + carry) % 10;
				carry = (digits[i] + carry) / 10;
			}
			if (carry == 1) {
				results[0] = 1;
				return results;
			} else {
				return Arrays.copyOfRange(results, 1, len + 1);
			}
		}
	}
}
