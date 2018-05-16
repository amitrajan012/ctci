package Chapter2;

import java.util.HashSet;
import java.util.Set;

import helpers.*;

/**
 * 
 * @author amitrajan
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP : How would you solve this problem if a temporary buffer is not allowed?
 *
 */
public class Q2_1 {
	public static void removeDuplicates(LinkedListNode n) {
		Set<Integer> set = new HashSet<Integer>();
		LinkedListNode prev = null;
		while(n != null) {
			if(set.contains(n.data)) {
				//Delete the node
				prev.next = n.next;
			}else {
				//Add the value to the HashSet
				set.add(n.data);
			}
			prev = n;
			n = n.next;
		}
	}
	
	//Without extra space : Complexity O(n^2)
	public static void removeDuplicates2(LinkedListNode n) {
		while(n != null) {
			LinkedListNode pointer = n;
			while(pointer.next != null) {
				if(pointer.next.data == n.data) {
					pointer.next = pointer.next.next;
				}else {
					pointer = pointer.next;
				}
			}
			n = n.next;
		}
	}
	
	public static void main(String[] args) {
		int[] list = {1,1,2,3,3,4,2,5,5};
		LinkedListNode  node1 = LinkedListNode.buildList(list);
		LinkedListNode  node2 = LinkedListNode.buildList(list);
		LinkedListNode.printList(node1);
		removeDuplicates(node1);
		LinkedListNode.printList(node1);
		removeDuplicates(node2);
		LinkedListNode.printList(node2);
	}

}
