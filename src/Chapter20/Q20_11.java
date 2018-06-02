package Chapter20;
/*
 * Imagine you have a square matrix, where each cell is filled with either black or white.
 * Design an algorithm to find the maximum subsquare such that all four borders are filled with black pixels.
 */
public class Q20_11 {
	public static SubSquare findMaximumSubSquare(int[][] A) {
		int N = A.length;
		int currentMaxSize = 0;
		SubSquare s = null;
		int col = 0; //Start from leftmost column
		
		//Iterate through columns from left to right
		while(N-col > currentMaxSize) {
			for(int row=0; row<N;row++) {
				int size = N - Math.max(row, col);
				while(size > currentMaxSize) {
					if(isSquare(A, row, col, size)) {
						currentMaxSize = size;
						s = new SubSquare(row, col, size);
						break;
					}
					size--;
				}
			}
			col++;
		}
		
		return s;
	}
	
	public static boolean isSquare(int[][] A, int row, int col, int size) {
		//Check Top and bottom
		for(int j=0;j<size;j++) {
			if(A[row][col+j] == 1) {
				return false;
			}
			if(A[row+size-1][col+j] == 1) {
				return false;
			}
		}
		
		//Check left and right
		for(int i=0;i<size;i++) {
			if(A[row+i][col] == 1) {
				return false;
			}
			if(A[row+i][col+size-1] == 1) {
				return false;
			}
		}
		return true;
	}
}

class SubSquare {
	public int row, col, size;
	public SubSquare(int r, int c, int s) {
		row = r; col = c; size = s;
	}
}
