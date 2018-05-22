package Chapter4;

import helpers.TreeNode;

/**
 * 
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
 *
 */
public class Q4_3 {
	public static TreeNode createBST(int[] a, int start, int end) {
		//Start inserting mid in the tree and call recursively with left and right array for left and right subtree
		if(a == null || a.length == 0) return null;
		if(start > end) return null;
		int mid = start + (end-start)/2;
		TreeNode n = new TreeNode(mid);
		n.left = createBST(a, start, mid-1);
		n.right = createBST(a, mid+1, end);
		return n;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {0,1,2,3,4};
		TreeNode.printTree(createBST(a, 0, a.length));
		a = new int[] {-1,0,1,3,4,7,9};
		TreeNode.printTree(createBST(a, 0, a.length));
	}
}
