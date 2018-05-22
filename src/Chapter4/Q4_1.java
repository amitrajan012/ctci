package Chapter4;

import helpers.TreeNode;

/**
 * 
 * @author amitrajan
 * Implement a function to check if a tree is balanced. 
 * For the purposes of this question, a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one.
 *
 */

public class Q4_1 {
	public static boolean isBalanced(TreeNode t) {
		if(t == null) return true;
		return Math.abs(height(t.left) - height(t.right)) <= 1 && isBalanced(t.left) && isBalanced(t.right);
	}

	public static int height(TreeNode t) {
		if(t == null) return 0;
		return 1 + Math.max(height(t.left), height(t.right));
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		n1.left = new TreeNode(2);
		n1.right = new TreeNode(3);
		TreeNode r = new TreeNode(4);
		r.left = n1;
		r.right = new TreeNode(5);
		TreeNode.printTree(r);
		System.out.println(isBalanced(r));
		
		TreeNode n2 = new TreeNode(3);
		n2.right = new TreeNode(6);
		TreeNode n3 = new TreeNode(1);
		n3.left = new TreeNode(2);
		n3.right = n2;
		TreeNode s = new TreeNode(4);
		s.left = n3;
		s.right = new TreeNode(5);
		TreeNode.printTree(s);
		System.out.println(isBalanced(s));
	}
}
