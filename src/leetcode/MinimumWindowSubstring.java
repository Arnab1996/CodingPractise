package leetcode;

public class MinimumWindowSubstring {
	public static void main(String[] args) {
		MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
		System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
	}

	public String minWindow(String s, String t) {
		if (s == null || t == null)
			return "";

		int len1 = s.length();
		int len2 = t.length();

		if (len2 > len1)
			return "";

		int hashPat[] = new int[256];
		int hashStr[] = new int[256];

		for (int i = 0; i < len2; i++)
			hashPat[t.charAt(i)]++;

		int start = 0, startIndex = -1, minLen = Integer.MAX_VALUE;

		int count = 0;
		for (int j = 0; j < len1; j++) {
			hashStr[s.charAt(j)]++;

			if (hashStr[s.charAt(j)] <= hashPat[s.charAt(j)])
				count++;

			if (count == len2) {
				while (hashStr[s.charAt(start)] > hashPat[s.charAt(start)] || hashPat[s.charAt(start)] == 0) {
					if (hashStr[s.charAt(start)] > hashPat[s.charAt(start)])
						hashStr[s.charAt(start)]--;
					start++;
				}
				int lenWindow = j - start + 1;
				if (minLen > lenWindow) {
					minLen = lenWindow;
					startIndex = start;
				}
			}
		}

		if (startIndex == -1)
			return "";

		return s.substring(startIndex, startIndex + minLen);

	}

}
