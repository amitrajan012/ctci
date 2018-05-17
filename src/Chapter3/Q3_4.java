package Chapter3;

import java.util.Stack;

/**
 * 
 * In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different sizes which can slide onto any tower.
 *  The puzzle starts with disks sorted in ascending order of size from top to bottom (e.g., each disk sits on top of an even larger one).
 *   You have the following constraints:
 *	(A) Only one disk can be moved at a time.
 *	(B) A disk is slid off the top of one rod onto the next rod.
 *	(C) A disk can only be placed on top of a larger disk.
 * Write a program to move the disks from the first rod to the last using Stacks.
 *
 */

public class Q3_4 {
	private static Stack<Integer> from = new Stack<Integer>();
	private static Stack<Integer> to = new Stack<Integer>();
	private static Stack<Integer> buffer = new Stack<Integer>();
	
	public static void moveTop(Stack<Integer> from, Stack<Integer> to) {
		if(to.isEmpty() || to.peek() > from.peek() ) {
			//Move the element
			to.push(from.pop());
		}
	}
	
	public static void moveDisks(int count, Stack<Integer> from, Stack<Integer> to, Stack<Integer> buffer) {
		if(count <= 0) {
			return;
		}
		moveDisks(count-1, from, buffer, to);
		moveTop(from, to);
		moveDisks(count-1, buffer, to, from);
	}
	
	public static void main(String[] args) {
		int disks = 5;
		from.push(5); from.push(4); from.push(3); from.push(2); from.push(1);
		moveDisks(5, from, to, buffer);
		for(int i=1;i<=disks;i++) {
			System.out.println(to.pop());	
		}
	}
}
