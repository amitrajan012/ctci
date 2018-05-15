package Chapter1;
import static helpers.Printers.*;
/**
 * 
 * @author amitrajan
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 *  Can you do this in place?
 *
 */

public class Q1_6 {
	public static int[][] rotate(int[][] M){
		int N = M.length;
		int[][] res = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				res[j][N-1-i] = M[i][j]; 
			}
		}
		return res;
	}
	
	public static void rotateInPlace(int[][] M){
		//N x N matrix will have floor(N/2) square cycles.
		//The first cycle is formed by its 1st row, last column, last row and 1st column.
		//The second cycle is formed by 2nd row, second-last column, second-last row and 2nd column.
		int N = M.length;
		for(int i=0;i<N/2;i++) {
			for(int j=i;j<N-i-1;j++) {
				int temp = M[j][N-1-i];
				M[j][N-1-i] = M[i][j];
				M[i][j] = M[N-1-j][i];
				M[N-1-j][i] = M[N-1-i][N-1-j];
				M[N-1-i][N-1-j] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] a = {{1, 2, 3, 4, 5},
                {11,22,33,44,55},
                {5, 4, 3, 2, 1},
                {55,44,33,22,11},
                {6, 7, 8, 9, 0}};
		printArray(a);
		printArray(rotate(a));
		rotateInPlace(a);
		printArray(a);		
	}
}
