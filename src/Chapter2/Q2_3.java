package Chapter2;

import helpers.LinkedListNode;

/**
 * 
 * @author amitrajan
 * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
 *
 */

public class Q2_3 {
	public static boolean deleteNode(LinkedListNode n) {
		//This problem can not be solved if the node to be deleted is the last node
		if(n == null || n.next == null) {
			return false;
		}
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
	
	public static void main(String[] args) {
		int[] list = {1,1,2,3,3,4,2,5,5};
		LinkedListNode  node = LinkedListNode.buildList(list);
		LinkedListNode.printList(node);
		deleteNode(node.next.next.next.next.next);
		LinkedListNode.printList(node);
	}
}
