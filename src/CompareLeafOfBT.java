import java.util.Stack;

public class CompareLeafOfBT {
	static class Node {
		String data;
		Node left, right;

		public Node(String data) {
			this.data = data;
			this.left = this.right = null;
		}

		public boolean isLeaf() {
			return (this.left == null && this.right == null);
		}
	}

	public static void printTree(Node tree) {
		if (tree == null) {
			return;
		}

		System.out.print(tree.data + "  ");
		if (tree.left != null) {
			printTree(tree.left);
		}
		if (tree.right != null) {
			printTree(tree.right);
		}
	}

	public static void main(String[] args) {
		Node root1 = new Node("");
		root1.left = new Node("");
		root1.left.left = new Node("abc");
		root1.right = new Node("");
		root1.right.left = new Node("def");
		root1.right.right = new Node("xyz");
		printTree(root1);
		System.out.println();

		Node root2 = new Node("");
		root2.left = new Node("");
		root2.left.left = new Node("abc");
		root2.left.right = new Node("def");
		root2.right = new Node("");
		root2.right.right = new Node("xyz");
		// printTree(root2);
		System.out.println();

		// System.out.println("Are the two trees identical: " + compareLeaves(root1,
		// root2));

		root1 = invertTree(root1);
		printTree(root1);
		System.out.println();

	}

	private static Node invertTree(Node root) {
		if (root == null)
			return root;
		if (root.left == null && root.right == null)
			return root;

		Node left = invertTree(root.left);
		Node right = invertTree(root.right);

		root.left = right;
		root.right = left;

		return root;
	}

	public static boolean compareLeaves(Node root1, Node root2) {
		Stack<Node> tree1 = new Stack<>();
		Stack<Node> tree2 = new Stack<>();

		tree1.push(root1);
		tree2.push(root2);

		while (!tree1.isEmpty() || !tree2.isEmpty()) {

			if (tree1.isEmpty() || tree2.isEmpty())
				return false;

			Node temp1 = tree1.pop();

			while (temp1 != null && !temp1.isLeaf()) {
				if (temp1.right != null)
					tree1.push(temp1.right);

				if (temp1.left != null)
					tree1.push(temp1.left);

				temp1 = tree1.pop();
			}

			Node temp2 = tree2.pop();
			while (temp2 != null && !temp2.isLeaf()) {
				if (temp2.right != null)
					tree2.push(temp2.right);

				if (temp2.left != null)
					tree2.push(temp2.left);

				temp2 = tree2.pop();
			}

			if (temp1 == null && temp2 != null)
				return false;

			if (temp1 != null && temp2 == null)
				return false;

			if (temp1 != null && temp2 != null) {
				if (temp1.data != temp2.data)
					return false;
			}
		}
		return true;
	}

}
