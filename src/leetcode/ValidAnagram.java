package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	public static void main(String[] args) {
		ValidAnagram anagram = new ValidAnagram();
		System.out.println(anagram.isAnagram("rat", "car"));
	}

	public boolean isAnagram(String s, String t) {
		if (s == null && t == null)
			return true;
		if (s.length() == 0 && t.length() == 0)
			return true;
		if (s.equals(t))
			return true;
		if (s.length() != t.length())
			return false;
		

		Map<Character, Integer> set1 = new HashMap<>();
		Map<Character, Integer> set2 = new HashMap<>();

		for (char s_i : s.toCharArray())
			set1.put(s_i, set1.getOrDefault(s_i, 0) + 1);
		for (char t_i : t.toCharArray())
			set2.put(t_i, set2.getOrDefault(t_i, 0) + 1);
		return set1.equals(set2);
	}

}
