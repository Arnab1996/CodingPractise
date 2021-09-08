package hackerrank.adhoc;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("TrieNode [children=").append(children).append(", endOfWord=").append(endOfWord).append("]\n");
			return builder.toString();
		}

	}

	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	void insert(String value) {
		TrieNode current = root;
		for (char c : value.toCharArray()) {
			TrieNode node = current.children.get(c);
			if (node == null) {
				node = new TrieNode();
				current.children.put(c, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}

	boolean search(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			TrieNode node = current.children.get(c);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.endOfWord;
	}

	void delete(String value) {
		delete(root, value, 0);
	}

	boolean delete(TrieNode current, String value, int index) {
		if (index == value.length()) {
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			return current.children.size() == 0;
		}
		char ch = value.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, value, index + 1);
		if (shouldDeleteCurrentNode) {
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;
	}

	void printTrie() {
		System.out.println(root);
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("abcd");
		trie.insert("lmno");
		trie.insert("abgl");
		System.out.println(trie.search("ab"));
		System.out.println(trie.search("abgl"));
		System.out.println(trie.search("abcde"));
		trie.delete("abcd");
		trie.printTrie();
	}

}
