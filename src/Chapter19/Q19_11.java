package Chapter19;

import java.util.Arrays;

/*
 * Design an algorithm to find all pairs of integers within an array which sum to a specified value.
 */
public class Q19_11 {
	public static void findPairs(int[] A, int sum) {
		Arrays.sort(A);
		int first = 0;
		int last = A.length-1;
		while(first < last) {
			int s = A[first]+A[last];
			if(s == sum) {
				System.out.println(A[first] + " " + A[last]);
				first++; last--;
			}else if(s < sum) {
				first++;
			}else {
				last--;
			}
		}
	}
	
	public static void main(String[] args) {
		findPairs(new int[] {3, -2,  9, -1, 14, 0, 5, 7, 13, 6}, 3);
	}
}
