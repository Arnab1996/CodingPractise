package com.arnab.hackerrank;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Array2BST {

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	static Node root;

	static Node sortedArrayToBST(int arr[], int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);
		node.left = sortedArrayToBST(arr, start, mid - 1);
		node.right = sortedArrayToBST(arr, mid + 1, end);

		return node;
	}

	static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));

		int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int n = arr.length;
		root = sortedArrayToBST(arr, 0, n - 1);
		System.out.println("Preorder traversal of constructed BST");
		preOrder(root);
		System.out.println("\nInorder traversal of constructed BST");
		inOrder(root);
		scanner.close();
	}

}
