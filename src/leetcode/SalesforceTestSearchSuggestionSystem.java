package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNode {
    TrieNode[] children;
    List<String> suggestions;

    TrieNode() {
        children = new TrieNode[26];
        suggestions = new ArrayList<>();
    }
}

public class SalesforceTestSearchSuggestionSystem {
    /*
    for an array of n strings products and a word to search, search design a system
    that when each character of the searched word is typed, suggests at most three
    product names from the products array. The suggested products should share a common
    prefix with they searched word, if more than three products exists with common prefix,
    report three of the lexicographically sorted.
     */

    public static void main(String[] args) {
        List<String> products = Arrays.asList("mobile", "mouse", "moneypot", "monitor", "mousepad");
        String searchWord = "mouse";

        List<List<String>> suggestions = suggestedProducts(products, searchWord);
        System.out.println("Product Suggestions: " + suggestions);
    }

    public static List<List<String>> suggestedProducts(List<String> products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product : products) {
            insertProduct(root, product);
        }

        return searchSuggestions(root, searchWord);
    }

    private static void insertProduct(TrieNode root, String product) {
        TrieNode node = root;
        for (char c : product.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.suggestions.add(product);
            node.suggestions.sort(String::compareTo); // Sort the suggestions for lexicographical order
            if (node.suggestions.size() > 3) {
                node.suggestions.remove(3); // Keep only the top 3 suggestions
            }
        }
    }

    private static List<List<String>> searchSuggestions(TrieNode root, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;

        for (char c : searchWord.toCharArray()) {
            if (node != null) {
                node = node.children[c - 'a'];
            }
            result.add((node == null) ? new ArrayList<>() : node.suggestions);
        }

        return result;
    }
}
