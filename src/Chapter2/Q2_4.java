package Chapter2;
/**
 * 
 * @author amitrajan
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 *
 */

import helpers.LinkedListNode;

public class Q2_4 {
	public static LinkedListNode add(LinkedListNode n1, LinkedListNode n2, int carry) {
		if(n1 == null && n2 == null) {
			if(carry == 0) {
				return null;
			}else {
				return new LinkedListNode(carry);
			}
		}
		LinkedListNode res = new LinkedListNode(carry);
		int val= carry;
		if(n1 != null) {
			val += n1.data; 
		}
		if(n2 != null) {
			val += n2.data; 
		}
		res.data = val%10;
		LinkedListNode tail = add(n1 == null ? null : n1.next, n2 == null ? null : n2.next, val/10);
		res.next = tail;
		return res;
	}
	
	public static void main(String[] args) {
		int[] list1 = {1,1,7};
		LinkedListNode  node1 = LinkedListNode.buildList(list1);
		int[] list2 = {4,2,5,9,9,5,4};
		LinkedListNode  node2 = LinkedListNode.buildList(list2);
		LinkedListNode.printList(node1);
		LinkedListNode.printList(node2);
		LinkedListNode.printList(add(node1, node2, 0));
	}
}
