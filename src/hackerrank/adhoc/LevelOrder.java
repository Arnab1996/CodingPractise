package hackerrank.adhoc;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
	// A Binary Tree Node
	static class Node {
		int data;
		Node left;
		Node right;

		// constructor
		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	// Iterative method to do level order traversal line by line
	static void printLevelOrder(Node root) {
		// Base Case
		if (root == null)
			return;

		// Create an empty queue for level order traversal
		Queue<Node> q = new LinkedList<Node>();

		// Enqueue Root and initialize height
		q.add(root);
		
		while (true) {
			int size = q.size();
			if(size == 0) {
				break;
			}
			while (size > 0) {
				Node node = q.remove();
				System.out.print(node.data + " ");
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				size--;
			}
			System.out.println();
		}

	}

	// Driver program to test above functions
	public static void main(String[] args) {
		 // Let us create binary tree shown in above diagram 
	       /*             1 
	                   /     \ 
	                  2       3 
	                /   \       \ 
	               4     5       6 
	        */

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);

		printLevelOrder(root);

	}
}
