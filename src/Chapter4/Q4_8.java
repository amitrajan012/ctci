package Chapter4;

import java.util.LinkedList;
import java.util.List;

import helpers.TreeNode;

/**
 * 
 * You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum up to that value. 
 * Note that it can be any path in the tree - it does not have to start at the root.
 *
 */
public class Q4_8 {
	//Need to do the pre-order(root, left, right) traversal of the tree
	//At each node check whether a path exists or not
	@SuppressWarnings("unchecked")
	public static void findPath(int sum, TreeNode root, LinkedList<TreeNode> path, LinkedList<List<TreeNode>> result, int level) {
		if(root == null) return;
		path.add(root);
		int temp = sum;
		for(int i=level;i>=0;i--) {
			temp -= path.get(i).value;
			if(temp == 0) {
				result.add(path.subList(i, level+1));
			}
		}
		
		LinkedList<TreeNode> p1 = (LinkedList<TreeNode>)path.clone();
		LinkedList<TreeNode> p2 = (LinkedList<TreeNode>)path.clone();
		
		findPath(sum, root.left, p1, result, level+1);
		findPath(sum, root.right, p2, result, level+1);
	}

	public static void main(String[] args) {
		/*
         *     4
         *    / \
         *   5   2
         *  / \   \
         * 1   3   7
         * \   /  /
         *  8 6  9
         */
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(2), n3 = new TreeNode(3),
                 n4 = new TreeNode(4), n5 = new TreeNode(5), n6 = new TreeNode(6),
                 n7 = new TreeNode(7), n8 = new TreeNode(8), n9 = new TreeNode(9);
        n4.left = n5; n4.right = n2; n5.left = n1; n5.right = n3; n1.right = n8;
        n3.left = n6; n2.right = n7; n7.left = n9;
        
        LinkedList<List<TreeNode>> result = new LinkedList<List<TreeNode>>();
        findPath(9, n4, new LinkedList<TreeNode>(), result, 0);
        
        for(List<TreeNode> l: result) {
        		for(TreeNode t: l) {
        			System.out.print(t.value);
        			System.out.print(" ");
        		}
        		System.out.print("\n");
        }
		
	}
}
