package Chapter20;
/*
 * Numbers are randomly generated and passed to a method. Write a program to find and maintain the median value as new values are generated.
 */

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Locale.LanguageRange;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class Q20_9 {
	//Can use two heaps
	//Max heap for the values below the median and min heap for values above the median
	//meadian will be the largest value of the max heap\
	//When a new value arrives, it is placed in the max heap (values below median) if it is <= the median
	//and placed on the min heap (values above the median) if it is > median
	//Heap sizes should be equal (or max heap can have one extra element)
	//This constraint can be maintained by shifting an element from one heap to another
	//Complexity: Median is available in constant time, Updates take O(log n) time
	
	private static PriorityQueue<Integer> smallerHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); //For numbers smaller than Median
	private static  PriorityQueue<Integer> largerHeap = new PriorityQueue<Integer>(); //For numbers greater than Median
	
	public static void addNumber(int n) {
		if(smallerHeap.size() == largerHeap.size()) {
			if(largerHeap.peek() != null && n > largerHeap.peek()) {
				smallerHeap.offer(largerHeap.poll());
				largerHeap.offer(n);
			}else {
				smallerHeap.offer(n);
			}
		}else {
			if(n < smallerHeap.peek()) {
				largerHeap.offer(smallerHeap.poll());
				smallerHeap.offer(n);
			}else {
				largerHeap.offer(n);
			}
		}
	}
	
	public static double getMedian() {
		if(smallerHeap.isEmpty()) return largerHeap.peek();
		else if(largerHeap.isEmpty()) return smallerHeap.peek();
		else if(largerHeap.size() == smallerHeap.size()) return (largerHeap.peek()+smallerHeap.peek())/2.0;
		else if(largerHeap.size() > smallerHeap.size()) return largerHeap.peek();
		else return smallerHeap.peek();
	}
	
	public static void main(String[] args) {
		addNumber(1); addNumber(2); addNumber(3); addNumber(4); addNumber(5); addNumber(6);
		System.out.println("Median is: " + getMedian());
	}
}	
