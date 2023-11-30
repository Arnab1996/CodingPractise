package leetcode;
/*
Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";

        int len1 = s.length();
        int len2 = t.length();

        if (len2 > len1) return "";

        int hashPat[] = new int[256];
        int hashStr[] = new int[256];

        for (int i = 0; i < len2; i++)
            hashPat[t.charAt(i)]++;

        int start = 0, startIndex = -1, minLen = Integer.MAX_VALUE;

        int count = 0;
        for (int j = 0; j < len1; j++) {
            hashStr[s.charAt(j)]++;

            if (hashStr[s.charAt(j)] <= hashPat[s.charAt(j)]) count++;

            if (count == len2) {
                while (hashStr[s.charAt(start)] > hashPat[s.charAt(start)] || hashPat[s.charAt(start)] == 0) {
                    if (hashStr[s.charAt(start)] > hashPat[s.charAt(start)]) {
                        hashStr[s.charAt(start)]--;
                    }
                    start++;
                }
                int lenWindow = j - start + 1;
                if (minLen > lenWindow) {
                    minLen = lenWindow;
                    startIndex = start;
                }
            }
        }
        if (startIndex == -1) return "";
        return s.substring(startIndex, startIndex + minLen);
    }
}
