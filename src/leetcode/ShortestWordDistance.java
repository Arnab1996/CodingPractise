package leetcode;
/*
Given a list of words and two wordsword1_and_word2, return the shortest distance between these two words in the list.
Example:
Assume that words =["practice", "makes", "perfect", "coding", "makes"].
Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and _word1 _and _word2 _are both in the list.
 */
public class ShortestWordDistance {
    public static void main(String[] args) {
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestWordDistance.shortestDistance(words, "coding", "practice"));
        System.out.println(shortestWordDistance.shortestDistance(words, "makes", "coding"));
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int word1Index = -1;
        int word2Index = -1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                word1Index = i;
            } else if (word.equals(word2)) {
                word2Index = i;
            }
            if (word1Index != -1 && word2Index != -1) {
                minDistance = Math.min(minDistance, Math.abs(word1Index - word2Index));
            }
        }
        return minDistance;
    }
}
