package hackerrank.adhoc;

import java.util.HashMap;
import java.util.Map;

public class OrderTraversalToTree {

	public static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static Node buildUtil(int[] in, int[] post, int inStrt, int inEnd, int pIndex, Map<Integer, Integer> map) {
		if (inStrt > inEnd)
			return null;

		int curr = post[pIndex];
		Node node = new Node(curr);
		pIndex--;

		if (inStrt == inEnd)
			return node;

		int iIndex = map.get(curr);
		node.right = buildUtil(in, post, iIndex + 1, inEnd, pIndex, map);
		node.left = buildUtil(in, post, inStrt, iIndex - 1, pIndex, map);
		return node;
	}

	public static Node buildTree(int[] in, int[] post, int len) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			map.put(in[i], i);
		}
		int index = len - 1;
		return buildUtil(in, post, 0, len - 1, index, map);
	}

	static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void main(String[] args) {
		int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
		int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };

		Node root = buildTree(in, post, in.length);

		System.out.println("Preorder of the constructed tree : ");
		preOrder(root);

	}

}
