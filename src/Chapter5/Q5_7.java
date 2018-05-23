package Chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * An array A[1... n] contains all the integers from 0 to n except for one number which is missing. 
 * In this problem, we cannot access an entire integer in A with a single operation. 
 * The elements of A are represented in binary, and the only operation we can use to access them is “fetch the jth bit of A[i]”, which takes constant time. 
 * Write code to find the missing integer. Can you do it in O(n) time?
 *
 */

public class Q5_7 {
	/* SOLUTION
     * 1. Start with the least significant bit (LSB(0)).
     * 2. Count occurrences of 1's vs 0's.
     * 3. If count(1) < count(0), then the missing number has a 1 as its LSB,
     *    else it has a 0.
     * 4. Retain all numbers with LSB matching result found in step 3.
     * 5. Repeat steps 1-4, iterating from least significant bit (LSB(0))
     *    -> 2nd least significant bit (LSB(1)) -> ...
     *    -> most significant bit (LSB(N))
     */
	
	public static int findMissingNumber(ArrayList<Integer> A) {
		int res  = 0;
		int j = 0;
		while(A.size() > 0) {
			int bit = findMissingBit(A, j);
			res |= (bit << j);
			A = filter(A, j, bit);
			++j;
		}
		return res;
	}

	public static ArrayList<Integer> filter(ArrayList<Integer> A, int j, int bit) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(Integer a: A) {
			if(((a >> j) & 1) == bit) {
				res.add(a);
			}
		}
		return res;
	}

	public static int findMissingBit(ArrayList<Integer> A, int j) {
		int ones = 0, zeroes = 0;
		for(Integer a: A) {
			int bit = (a >> j) & 1;
			if(bit == 1) {
				ones++;
			}else {
				zeroes++;
			}
		}
		return (ones < zeroes) ? 1 : 0;
	}
	
	public static void main(String[] args) {
		Integer[] a = {0,1,2,3,4,6,7,8,9,10};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(a));
        Collections.shuffle(list);
        
        System.out.println("Missing number is: " + findMissingNumber(list));
	}
	
}
