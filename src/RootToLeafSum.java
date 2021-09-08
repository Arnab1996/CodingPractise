import java.util.ArrayList;
import java.util.List;

public class RootToLeafSum {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}

		@Override
		public String toString() {
			return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
		}

	}

	class MinMax{
	    int min;
	    int max;
	    boolean isBST;
	    int size ;
	    
	    MinMax(){
	        min = Integer.MAX_VALUE;
	        max = Integer.MIN_VALUE;
	        isBST = true;
	        size = 0;
	    }
	}

	static List<Integer> results = new ArrayList<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(16);
		root.left.right = new TreeNode(-3);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(11);
		boolean hasResult = rootToLeafSum(root, 26);
		if (hasResult)
			System.out.println(results);
		else
			System.out.println("No solution exists");

		System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}
	
	public int largestBST(TreeNode root){
        MinMax m = largest(root);
        return m.size;
    }
	
	static int res = Integer.MIN_VALUE;
	
	static int findMaxUtil(TreeNode node)
    {
 
        // Base Case
        if (node == null)
            return 0;
 
        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l = findMaxUtil(node.left);
        int r = findMaxUtil(node.right);
 
        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + node.data,
                                  node.data);
 
 
        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.data);
 
        // Store the Maximum Result.
        res = Math.max(res, max_top);
 
        return max_single;
    }
    
    private MinMax largest(TreeNode root){
        //if root is null return min as Integer.MAX and max as Integer.MIN 
        if(root == null){
            return new MinMax();
        }
        
        //postorder traversal of tree. First visit left and right then
        //use information of left and right to calculate largest BST.
        MinMax leftMinMax = largest(root.left);
        MinMax rightMinMax =largest(root.right);
        
        MinMax m = new MinMax();
        
        //if either of left or right subtree says its not BST or the data
        //of this node is not greater/equal than max of left and less than min of right
        //then subtree with this node as root will not be BST. 
        //Return false and max size of left and right subtree to parent
        if(leftMinMax.isBST == false || rightMinMax.isBST == false || (leftMinMax.max > root.data || rightMinMax.min <= root.data)){
            m.isBST = false;
            m.size = Math.max(leftMinMax.size, rightMinMax.size);
            return m;
        }
        
        //if we reach this point means subtree with this node as root is BST.
        //Set isBST as true. Then set size as size of left + size of right + 1.
        //Set min and max to be returned to parent.
        m.isBST = true;
        m.size = leftMinMax.size + rightMinMax.size + 1;
     
        //if root.left is null then set root.data as min else
        //take min of left side as min
        m.min = root.left != null ? leftMinMax.min : root.data;
  
        //if root.right is null then set root.data as max else
        //take max of right side as max.
        m.max = root.right != null ? rightMinMax.max : root.data;
   
        return m;
    }
    

	private static boolean isBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;

		if (root.data <= min && root.data > max)
			return false;

		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);

	}

	private static boolean rootToLeafSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null) {
			if (root.data == sum) {
				results.add(root.data);
				return true;
			} else
				return false;
		}

		if (rootToLeafSum(root.left, sum - root.data) || rootToLeafSum(root.right, sum - root.data)) {
			results.add(root.data);
			return true;
		}

		// if (rootToLeafSum(root.right, sum - root.data)) {
		// results.add(root.data);
		// return true;
		// }

		return false;
	}

}
