package leetcode;

import java.util.HashMap;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
	public static void main(String[] args) {
		LongestSubstringwithAtMostTwoDistinctCharacters atMostTwoDistinctCharacters = new LongestSubstringwithAtMostTwoDistinctCharacters();
		System.out.println(atMostTwoDistinctCharacters.lengthOfLongestSubstringTwoDistinct("eceba"));
	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0)
			return 0;
		char[] arr = s.toCharArray();

		int max = Integer.MIN_VALUE;

		HashMap<Character, Integer> map = new HashMap<>();
		int begin = 0, end = 0;
		while (end < s.length()) {

			if (map.size() <= 2) {
				map.put(arr[end], end++);
			}

			if (map.size() > 2) {
				int min = arr.length - 1;
				for (int value : map.values()) {
					min = Math.min(min, value);
				}
				begin = min + 1;
				map.remove(arr[min]);
			}
			max = Math.max(max, end - begin);
		}
		return max;
	}

}
