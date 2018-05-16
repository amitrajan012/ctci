package Chapter2;
/**
 * 
 * @author amitrajan
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
 *
 */

import helpers.LinkedListNode;

public class Q2_5 {
	public static LinkedListNode findBeginingOfLoop(LinkedListNode head) {
		LinkedListNode n1 = head; //Slow pointer
		LinkedListNode n2 = head; //Fast pointer
		//Find meeting point (It will be k steps away from the head, where k is the distance of start of the loop from the head)
		//n2 will be k steps away from the loop start as well
		while(n2 != null) {
			n1 = n1.next;
			n2 = n2.next.next;
			if(n1 == n2) {
				break;
			}
		}
		//When no loop is present
		if(n2 == null) {
			return null;
		}
		//Move n1 back to head and keep n2 at the meeting point
		//Move them at the same pace and they will meet at the start of the loop
		n1 = head;
		while(n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n2;
	}
	
	public static void main(String[] args) {
		int[] list = {1,2,3,4,5,6};
        LinkedListNode n = LinkedListNode.buildList(list), head = n;

        //Form Circular Linked List
        while (n.next != null) {
        		n = n.next;
        }
        n.next = head.next.next.next;
        System.out.println(findBeginingOfLoop(head).data);
	}
}
