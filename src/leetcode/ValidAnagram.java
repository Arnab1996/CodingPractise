package leetcode;

import java.util.HashMap;
import java.util.Map;
/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false


Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */
public class ValidAnagram {
	public static void main(String[] args) {
		ValidAnagram anagram = new ValidAnagram();
		System.out.println(anagram.isAnagramOptimized("anagram", "nagaram"));
	}

	public boolean isAnagram(String s, String t) {
		if (s == null && t == null)
			return true;
		if (s.isEmpty() && t.isEmpty())
			return true;
		if (s.equals(t))
			return true;
		if (s.length() != t.length())
			return false;

		Map<Character, Integer> stringOneMap = new HashMap<>();
		Map<Character, Integer> stringTwoMap = new HashMap<>();

		for (char s_i : s.toCharArray())
			stringOneMap.put(s_i, stringOneMap.getOrDefault(s_i, 0) + 1);
		for (char t_i : t.toCharArray())
			stringTwoMap.put(t_i, stringTwoMap.getOrDefault(t_i, 0) + 1);
		return stringOneMap.equals(stringTwoMap);
	}

	public boolean isAnagramOptimized(String s, String t) {
		if (s == null && t == null)
			return true;
		if (s.isEmpty() && t.isEmpty())
			return true;
		if (s.equals(t))
			return true;
		if (s.length() != t.length())
			return false;

		Map<Character, Integer> stringMap = new HashMap<>();
		for (char s_i : s.toCharArray())
			stringMap.put(s_i, stringMap.getOrDefault(s_i, 0) + 1);

		for (char t_i : t.toCharArray())
			stringMap.put(t_i, stringMap.getOrDefault(t_i, 0) - 1);

		for (int count: stringMap.values()) {
			if (count != 0) return false;
		}
		return true;
	}
}
