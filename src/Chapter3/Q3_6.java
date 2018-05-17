package Chapter3;

import java.util.Stack;

/**
 * 
 * Write a program to sort a stack in ascending order. You should not make any assumptions about how the stack is implemented. 
 * The following are the only functions that should be used to write this program: push | pop | peek | isEmpty.
 *
 */

public class Q3_6 {
	public static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> res = new Stack<Integer>();
		while(!s.isEmpty()) {
			int temp = s.pop();
			//Insert the element at it's apt position
			while(!res.isEmpty() && res.peek() > temp) {
				//Push back the elements of res to s
				s.push(res.pop());
			}
			res.push(temp);
		}
		return res;
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(23); s.push(2); s.push(13); s.push(4); s.push(11);
		Stack<Integer> r = sort(s);
		while(!r.isEmpty()) {
			System.out.println(r.pop());
		}
	}
}
