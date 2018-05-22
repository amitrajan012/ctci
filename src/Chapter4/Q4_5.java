package Chapter4;

import helpers.TreeNode;

/**
 * 
 * Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a given node in a binary search tree where each node has a link to its parent.
 *
 */
public class Q4_5 {
	public static TreeNode inOrderSuccessor(TreeNode t) {
		if(t == null) return null;
		//Case 1: If t has right subtree, return the leftmost child of right subtree
		if(t.right != null) return leftMostChild(t.right);
		//Case 2: If t does not have right subtree
		//		If t is left child of its parent, return its parent
		//		If t is right child of its parent, Go up until t is left child
		//		If t is the last node, return null
		while(t.parent != null && t.parent.right == t) {
			t = t.parent;
		}
		return t.parent;
	}
	
	public static TreeNode leftMostChild(TreeNode t) {
		if(t.left == null) return t;
		return leftMostChild(t.left);
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
		n1.left = n3; n3.parent = n1; n1.right = n4; n4.parent = n1;
		n2.right = n5; n5.parent = n2;
		TreeNode root = new TreeNode(4);
		root.left = n1; root.right = n2; n1.parent = root; n2.parent = root;
		
		System.out.println(inOrderSuccessor(n3).value);
	}
}
