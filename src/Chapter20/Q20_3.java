package Chapter20;
/*
 * Write a method to randomly generate a set of m integers from an array of size n. Each element must have equal probability of being chosen.
 */
public class Q20_3 {
	public static int rand(int lower, int higher) {
		//Generate random number between lower and higher (inclusive)
		return lower + (int)(Math.random()*(higher-lower+1));
	}
	
	public static int[] selectRandomElements(int[] A, int m) {
		//Constraint: m <= A.length
		int[] res = new int[m];
		int N = A.length-1;
		for(int i=0;i<m;i++) {
			int j = rand(i, N);
			int temp = A[i];
			A[i] = A[j];
			res[i] = A[j];
			A[j] = temp;
		}
		return res; 
	}
	
	public static void main(String[] args) {
		int[] res = selectRandomElements(new int[] {23, 14, 12, 45, 6, 11, 18, 58, 9, 123}, 4);
		for(int i: res) {
			System.out.print(i + " ");
		}
	}
}
