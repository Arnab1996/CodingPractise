package leetcode;

public class CountCompleteTreeNodes {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		CountCompleteTreeNodes completeTreeNodes = new CountCompleteTreeNodes();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.left = new TreeNode(6);
		System.out.println(completeTreeNodes.countNodes(root));
	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int d = getDepth(root);
		if (d == 0) {
			return 1;
		}
		int start = 0;
		int end = (int) Math.pow(2, d) - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (exists(mid, d, root)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return (int) Math.pow(2, d) - 1 + start;
	}

	private int getDepth(TreeNode node) {
		int d = 0;
		while (node.left != null) {
			node = node.left;
			d++;
		}
		return d;
	}

	private boolean exists(int idx, int d, TreeNode root) {
		int left = 0;
		int right = (int) Math.pow(2, d) - 1;
		int mid;
		for (int i = 0; i < d; ++i) {
			mid = left + (right - left) / 2;
			if (idx <= mid) {
				root = root.left;
				right = mid;
			} else {
				root = root.right;
				left = mid + 1;
			}
		}
		return root != null;
	}

}
