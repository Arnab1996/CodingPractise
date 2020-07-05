package hackerrank.adhoc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	Node left, right;
	int data;

	Node(int d) {
		data = d;
		left = right = null;
	}

}

public class BT_To_DLL {
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

	void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void print(Node head) {
		Node prev = head;
		while (head != null) {
			System.out.print(head.data + " ");
			prev = head;
			head = head.right;
		}
		System.out.println();
		while (prev != null) {
			System.out.print(prev.data + " ");
			prev = prev.left;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int t = scanner.nextInt();
		while (t > 0) {
			String s = scanner.nextLine();
			Node root = buildTree(s);
			BT_To_DLL b = new BT_To_DLL();
			Node ans = b.bToDLL(root);
			while (ans.left != null) {
				ans = ans.left;
			}
			head = ans;
			print(head);
			t--;
			System.out.println();
		}
		scanner.close();
	}

	static Node head;

	private Node bToDLL(Node root) {
		if (root == null)
			return null;
		if (root.left != null) {
			Node l = bToDLL(root.left);
			while (l.right != null) {
				l = l.right;
			}
			l.right = root;
			root.left = l;
		}
		if (root.right != null) {
			Node r = bToDLL(root.right);
			while (r.left != null) {
				r = r.left;
			}
			r.left = root;
			root.right = r;
		}
		return root;
	}
}