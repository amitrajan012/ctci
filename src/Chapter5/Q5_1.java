package Chapter5;
/**
 * 
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
 * Write a method to set all bits between i and j in N equal to M (e.g., M becomes a substring of N located at i and starting at j).
 *
 */

public class Q5_1 {
	public static int setBits(int N, int M, int i, int j) {
		M = M << i;
		//Reset the bits of N from i to j
		int temp = (~(0 & 0) << (j+1)) | ((int)Math.pow(2, i) - 1); 
		N = N & temp;
		N = N | M;
		return N;
	}
	
	public static void main(String[] args) {
		int N = Integer.parseInt("11111111111111", 2);
		int M = Integer.parseInt("01110", 2);
		int res = setBits(N, M, 2, 6);
		
		System.out.println(Integer.toBinaryString(res));
	}
}
