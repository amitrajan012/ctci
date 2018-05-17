package Chapter3;
/**
 * 
 * @author amitrajan
 * Describe how you could use a single array to implement three stacks.
 *
 */

import java.util.Arrays;

public class Q3_1 {
	private static final int NUM_STACK = 3;
	private static final int SIZE = 20;
	
	private static int[] stackPointers = new int[NUM_STACK];
	static{Arrays.fill(stackPointers, -1);} //Static block: Code is executed once the object is initialized
	private int[] elements = new int[SIZE*NUM_STACK]; 
	
	public boolean push(int stackNum, int e) {
		if(isFull(stackNum)) {
			return false;
		}else {
			stackPointers[stackNum] += 1;
			elements[stackPointers[stackNum] + stackNum*SIZE] = e;
			return true;
		}
	}
	
	public int pop(int stackNum) {
		int val = peek(stackNum);
		stackPointers[stackNum] -= 1;
		return val;
	}
	
	public int peek(int stackNum) {
		if(isEmpty(stackNum)) {
			return Integer.MIN_VALUE;
		}else {
			return elements[stackPointers[stackNum] + stackNum*SIZE];
		}
	}
	
	public boolean isFull(int stackNum) {
		return stackPointers[stackNum] >= SIZE-1;
	}
	
	public boolean isEmpty(int stackNum) {
		return stackPointers[stackNum] == -1;
	}
	
	public static void main(String[] args) {
		Q3_1 stack = new Q3_1();
        stack.push(0, -1); stack.push(0, -2); stack.push(0, -3);
        stack.push(1, 1); stack.push(1, 2); stack.push(1, 3);
        stack.push(2, 10); stack.push(2, 20); stack.push(2, 30); stack.push(2, 40);
        System.out.println("Pop Stack 0: " + stack.pop(0));
        System.out.println("Pop Stack 1: " + stack.pop(1));
        System.out.println("Pop Stack 1: " + stack.pop(1));
        System.out.println("Pop Stack 2: " + stack.pop(2));
        System.out.println("Peek Stack 2: " + stack.peek(2));
        System.out.println("Pop Stack 2: " + stack.pop(2));
    }

}
