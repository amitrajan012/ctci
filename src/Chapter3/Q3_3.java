package Chapter3;
/**
 * SetOfStacks should be composed of several stacks, and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack 
 * (that is, pop() should return the same values as it would if there were just a single stack).
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q3_3 {
	private static final int STACK_SIZE = 2;
	private static List<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	
	public void push(int x) {
		if(stacks.size() == 0 || stacks.get(stacks.size()-1).size() == STACK_SIZE) {
			//If size of list of stacks is 0 or size of stack at the last position is equal to maximum size: add a new stack and push the element
			Stack<Integer> temp = new Stack<Integer>();
			temp.push(x);
			stacks.add(temp);
		}else {
			//Add element to the last stack
			stacks.get(stacks.size()-1).add(x);
		}
	}
	
	public void pop() {
		System.out.println("Popped element is: " +stacks.get(stacks.size()-1).pop());
		//Remove the last stack if it's empty
		if(stacks.get(stacks.size()-1).size() == 0) {
			stacks.remove(stacks.size()-1);
		}
	}
	
	public void popAt(int index) {
		System.out.println("Popped element at index :" +index +" is: " +stacks.get(index).pop()); //Assumption: The length of list of stacks is in range
		if(stacks.get(index).size() == 0) {
			stacks.remove(index); //Remove stack from the list as it's empty
		}
	}
	
	public void peek() {
		System.out.println("Peek element is: " +stacks.get(stacks.size()-1).peek());
	}
	
	public int size() {
		int s = 0;
		for(int i=0;i<stacks.size();i++) {
			s += stacks.get(i).size();
		}
		return s;
	}
	
	public static void main(String[] args) {
		Q3_3 s = new Q3_3();
        s.push(-1); s.push(10); s.push(-2); s.push(-3); s.push(12);
        s.popAt(0);
        s.peek();
        System.out.println("Size: " +s.size());
        s.popAt(0);
        s.popAt(1);
        System.out.println("Size: " +s.size());
        s.peek();
        s.pop();
        s.pop();
        System.out.println("Size: " +s.size());
    }
}
