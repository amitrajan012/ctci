package Chapter20;

import java.util.Arrays;

/*
 * Describe an algorithm to find the largest 1 million numbers in 1 billion numbers. Assume that the computer memory can hold all one billion numbers.
 */
public class Q20_6 {
	public static int[] findLargestElements(int[] A, int M) {
		Arrays.sort(A);
		int N = A.length;
		int[] res = new int[M];
		int index = 0;
		for(int i = N-1;i>=(N-M);i--) {
			res[index] = A[i];
			index++;
		}
		return res;
	}
	
	//Another approach
	//1. Create a Min Heap with the first million numbers.
	//2. For each remaining number, insert it in the Min Heap and then delete the minimum value from the heap.
	//3. The heap now contains the largest million numbers.
	//4. This algorithm is O(n log m), where m is the number of values we are looking for.
	public static void main(String[] args) {
		int[] A = {23, 34, 12, 33, 67, 78, 111, 9, 234};
		int[] res = findLargestElements(A, 3);
		for(int i: res) {
			System.out.print(i + " ");
		}
	}
}
