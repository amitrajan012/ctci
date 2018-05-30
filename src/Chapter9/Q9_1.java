package Chapter9;
/*
 * You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order.
 */
public class Q9_1 {
	public static void merge(int[] A, int[] B, int a, int b) {
		int pointer = a+b-1;//At the last position
		int i = a-1, j = b-1;
		while(i >= 0 && j >= 0) {
			if(A[i] > B[j]) {
				A[pointer--] = A[i--];
			}else {
				A[pointer--] = B[j--];
			}
		}
		
		//Check whether all the items in B has been copied or not
		while(j >= 0) {
			A[pointer--] = B[j--];
		}
	}
	
	public static void main(String[] args) {
		int[] A = new int[10];
		A[0] = 3; A[1] = 5; A[2] = 13; A[3] = 27; A[4] = 35;
		int[] B = new int[4];
		B[0] = 1; B[1] = 2; B[2] = 31; B[3] = 43;
		
		merge(A, B, 5, 4);
		for(int i: A) {
			System.out.println(i);
		}
	}
}
