package Chapter4;
/**
 * 
 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth 
 * (i.e., if you have a tree with depth D, you’ll have D linked lists).
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;

import helpers.TreeNode;

public class Q4_4 {
	public static ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root) {
		//Implement BFS (Queue is used)
		if(root == null) return null;
		ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			res.add(queue);
			LinkedList<TreeNode> temp = queue;
			queue = new LinkedList<TreeNode>();
			for(TreeNode t: temp) {
				if(t.left != null) queue.add(t.left);
				if(t.right != null) queue.add(t.right);
			}
		}
		return res;
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
		n1.left = new TreeNode(1); n1.right = new TreeNode(3);
		n2.right = new TreeNode(7);
		TreeNode root = new TreeNode(4);
		root.left = n1; root.right = n2;
		
		ArrayList<LinkedList<TreeNode>> res = createLinkedList(root);
		for(LinkedList<TreeNode> l: res) {
			for(TreeNode t: l) {
				System.out.print(t.value);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
}
