package hackerrank.adhoc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxPathSum {

	static class Node {
		Node left, right;
		int data;

		Node(int d) {
			data = d;
			left = right = null;
		}

	}

	static Node buildTree(String str) throws IOException {
		if (str.length() == 0 || str == null) {
			return null;
		}
		String ip[] = str.split(" ");
		Node root = new Node(Integer.parseInt(ip[0]));
		Queue<Node> Q = new LinkedList<>();
		Q.add(root);
		int i = 1;
		while (Q.size() > 0 && i < ip.length) {
			Node currNode = Q.remove();
			String currVal = ip[i];
			if (currVal != null) {
				currNode.left = new Node(Integer.parseInt(currVal));
				Q.add(currNode.left);
			}
			i++;
			if (i > ip.length)
				break;
			currVal = ip[i];
			if (currVal != null) {
				currNode.right = new Node(Integer.parseInt(currVal));
				Q.add(currNode.right);
			}
			i++;
		}
		return root;
	}

	static int value = Integer.MIN_VALUE;

	public static int pathSum(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.left == null && root.right == null) {
			return root.data;
		}
		int lsum = pathSum(root.left);
		int rsum = pathSum(root.right);
		if (root.left != null && root.right != null) {
			value = Math.max(value, root.data + lsum + rsum);
		}
		return Math.max(lsum, rsum) + root.data;
	}

	public static int maxPathSum(Node root) {
		// your code here
		pathSum(root);
		int t = value;
		value = Integer.MIN_VALUE;
		return t;

	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int t = scanner.nextInt();
		while (t > 0) {
			String s = scanner.nextLine();
			Node root = buildTree(s);
			t--;
			System.out.println(maxPathSum(root));
		}
		scanner.close();
	}

}
