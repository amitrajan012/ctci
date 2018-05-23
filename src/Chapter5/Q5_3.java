package Chapter5;
/**
 * 
 * Given an integer, print the next smallest and next largest number that have the same number of 1 bits in their binary representation.
 *
 */
public class Q5_3 {
	public static void printNumbers(int N) {
		int c = count(N);
		//Base case 
		if(c == 0 || c == 32) {
			System.out.println("No next smallest and largest number exists");
		}
		
		int nextLargest = N+1;
		while(count(nextLargest) != c) {
			nextLargest++;
		}
		System.out.println("Next largest number is: " + nextLargest);
		
		int nextSmallest = N-1;
		while(count(nextSmallest) != c) {
			nextSmallest--;
		}
		System.out.println("Next smallest number is: " + nextSmallest);
	}
	
	public static int count(int n) {
		//Count number of set bits
		int count = 0;
		while(n > 0) {
			n &= (n-1);
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		printNumbers(5);
	}
}
