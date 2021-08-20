package leetcode;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(characters.lengthOfLongestSubstring("bbbbb"));
	}

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int res = 0;
		int[] lastIndex = new int[256];
		Arrays.fill(lastIndex, -1);

		int i = 0;

		for (int j = 0; j < n; j++) {
			i = Math.max(i, lastIndex[s.charAt(j)] + 1);
			res = Math.max(res, j - i + 1);
			lastIndex[s.charAt(j)] = j;
		}
		return res;
	}

}
