package Chapter4;

import helpers.TreeNode;

/**
 * 
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. 
 * Create an algorithm to decide if T2 is a subtree of T1.
 *
 */
public class Q4_7 {
	public static boolean isSubTree(TreeNode t1, TreeNode t2) {
		if(t2 == null) return true;
		if(t1 == null) return false;
		if(isIdentical(t1, t2)) return true;
		return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
	}
	
	public static boolean isIdentical(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		if(t1.value != t2.value) return false;
		return isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
	}

	public static void main(String[] args) {
		/*
		 * 		4
		 * 	   / \
		 * 	  2   5
		 * 	 / \   \
		 *  1   3   7
		 */
		TreeNode n1 = new TreeNode(2), n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(1), n4 = new TreeNode(3), n5 = new TreeNode(7);
		n1.left = n3; n1.right = n4; 
		n2.right = n5; 
		TreeNode root = new TreeNode(4);
		root.left = n1; root.right = n2;
		
		System.out.println(isSubTree(root, n1));
	}
	
}
