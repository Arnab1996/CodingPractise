package com.arnab.hackerrank;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ZigZag {

	static class Node {
		int data;
		Node left;
		Node right;
	}

	static Node newNode(int val) {
		Node temp = new Node();
		temp.data = val;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	static Node buildTree(String str) {
		if (str.length() == 0 || str == null) {
			return null;
		}
		ArrayList<String> ip = new ArrayList<>();
		ip.add(str);
		Node root = newNode(str.charAt(0) - '0');
		Queue<Node> Q = new LinkedList<Node>();
		Q.add(root);
		int i = 1;
		while (!Q.isEmpty() && i < ip.size()) {
			Node currNode = Q.remove();
			String currVal = ip.get(i);
			if (currVal != null) {
				currNode.left = newNode(Integer.parseInt(currVal));
				Q.add(currNode.left);
			}
			i++;
			if (i >= ip.size()) {
				break;
			}
			currVal = ip.get(i);
			if (currVal != null) {
				currNode.right = newNode(Integer.parseInt(currVal));
				Q.add(currNode.right);
			}
			i++;
		}
		return root;
	}

	static void ZigZagTraversal(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> Q = new LinkedList<>();
		Q.add(root);
		Stack<Integer> st = new Stack<Integer>();
		boolean b = true;
		while (!Q.isEmpty()) {
			int s = Q.size();
			while (s-- != 0) {
				Node p = Q.remove();
				if (b) {
					System.out.print(p.data + " ");
				} else {
					st.add(p.data);
				}
				if (p.left != null) {
					Q.add(p.left);
				}
				if (p.right != null) {
					Q.add(p.right);
				}
			}
			while (st.size() != 0) {
				System.out.print(st.pop() + " ");
				b = !b;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			String S = scanner.next();
			
			Node root = buildTree(S);
			ZigZagTraversal(root);
		}
		scanner.close();
	}
}
