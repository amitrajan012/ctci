package Chapter1;
import static helpers.Printers.*;
/**
 * 
 * @author amitrajan
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 *
 */

public class Q1_7 {
	public static void replaceWithZeroes(int[][] M) {
		int[] row = new int[M.length];
		int[] col = new int[M.length];
		for(int i=0;i<M.length;i++) {
			for(int j=0;j<M[0].length;j++) {
				if(M[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		for(int i=0;i<row.length;i++) {
			if(row[i] == 1) {
				//Set entire row to 0
				M[i] = new int[M.length];
			}
		}
		for(int j=0;j<col.length;j++) {
			if(col[j] == 1) {
				//Set entire column to 0
				for(int i=0;i<M.length;i++) {
					M[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] a = {{1, 2, 3, 4, 5},
                {1,7,9,4,5},
                {5, 4, 3, 2, 1},
                {5,4,3,2,1},
                {6, 7, 0, 9, 0}};
		printArray(a);
		replaceWithZeroes(a);
		printArray(a);
	}
}
