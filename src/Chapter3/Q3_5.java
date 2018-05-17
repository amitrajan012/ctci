package Chapter3;

import java.util.Stack;

/**
 * 
 * @author amitrajan
 * Implement a MyQueue class which implements a queue using two stacks.
 *
 */

public class Q3_5 {
	private static Stack<Integer> s = new Stack<Integer>();
	private static Stack<Integer> q = new Stack<Integer>();
	
	public void add(int x) {
		if(!q.isEmpty()) {
			while(!q.isEmpty()) {
				s.push(q.pop());
			}
		}
		s.push(x);
	}
	
	public int remove() {
		if(q.isEmpty()) {
			while(!s.isEmpty()) {
				q.push(s.pop());
			}
		}
		return q.pop();
	}
	
	public int peek() {
		if(q.isEmpty()) {
			while(!s.isEmpty()) {
				q.push(s.pop());
			}
		}
		return q.peek();
	}
	
	public static void main(String[] args) {
		Q3_5 queue = new Q3_5();
		queue.add(1); queue.add(2); queue.add(3); queue.add(4); queue.add(5);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}
	
}
