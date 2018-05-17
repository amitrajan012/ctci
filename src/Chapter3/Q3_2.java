package Chapter3;
/**
 * 
 * @author amitrajan
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 *
 */

import java.util.Stack;

public class Q3_2 {
	//The idea is that the minimum element is not stored in the stack, instead something like 2*X - previousMin is stored whenever a new min element is pushed
	//Push: If new element(X) which is pushed is minimum, Store it in min value and push (2*X - previousMin) on the stack
	// [The idea is 2*newMin - previousMin will always be less than min element and hence while popping we can easily find whether the min element is popped or not]
	//Pop: If min element is popped, first retrieve previousMin as 2*min - topElement
	
	private static Stack<Integer> stack = new Stack<Integer>();
	private static int min;
	
	public void push(Integer x) {
		if(stack.isEmpty()) {
			min = x;
			stack.push(x); //Not pushing 2*X - previousMin as no previous min element
		}else if(x < min) {
			stack.push(2*x - min);
			min = x;
		}else {
			stack.push(x);
		}
	}
	
	public void pop() {
		if(!stack.isEmpty()) {
			int top = stack.pop();
			if(top < min) {
				//Minimum element is removed and hence retrieve previous min
				System.out.println("Popped element is: " +min);
				min = 2*min -top;
			}else {
				System.out.println("Popped element is: " +top);
			}
		}
	}
	
	public void peek() {
		if(!stack.isEmpty()) {
			int top = stack.peek();
			if(top < min) {
				//Minimum element is removed and hence retrieve previous min
				System.out.println("Peek element is: " +min);
				min = 2*min -top;
			}else {
				System.out.println("Peek element is: " +top);
			}
		}
	}
	
	public void getMin() {
		if(!stack.isEmpty())
			System.out.println("Minimum element is: " +min);
	}
	
	public static void main(String[] args) {
		Q3_2 s = new Q3_2();
        s.push(-1); s.push(10); s.push(-2); s.push(-3); s.push(12);
        s.getMin();
        s.pop();
        s.peek();
        s.pop();
        s.getMin();
        s.pop();
        s.getMin();
        s.peek();
    }
}
