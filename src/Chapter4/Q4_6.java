package Chapter4;

import helpers.TreeNode;

/**
 * 
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 *
 */
public class Q4_6 {
	public static TreeNode firstCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
		if(covers(root.left, n1) && covers(root.left, n2)) {
			return firstCommonAncestor(root.left, n1, n2);
		}else if(covers(root.right, n1) && covers(root.right, n2)) {
			return firstCommonAncestor(root.right, n1, n2);
		}else {
			return root;
		}
	}
	
	public static boolean covers(TreeNode root, TreeNode n) {
		if(root == null) return false;
		if(root == n) return true;
		return covers(root.left, n) || covers(root.right, n);
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
		
		System.out.println(firstCommonAncestor(root, n1, n5).value);
	}
}
