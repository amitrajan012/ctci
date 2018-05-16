package Chapter2;

import helpers.LinkedListNode;

/**
 * 
 * @author amitrajan
 * Implement an algorithm to find the nth to last element of a singly linked list.
 *
 */

public class Q2_2 {
	public static int findNthToLast(LinkedListNode node, int N) {
		int count = 1;
		LinkedListNode res = node;
		while(node != null) {
			if(count > N) {
				//N elements are traversed
				res = res.next;
				
			}
			node = node.next;
			count++;
		}
		return (count >= N) ? res.data : Integer.MIN_VALUE; //MIN_VALUE returned in case length of linked list is out of range 
	}
	
	public static void main(String[] args) {
		int[] list = {1,1,2,3,3,4,2,5,5};
		LinkedListNode  node = LinkedListNode.buildList(list);
		LinkedListNode.printList(node);
		int N = 11;
		System.out.println(N + "th/rd element from last is: " +findNthToLast(node, N));
	}
}
