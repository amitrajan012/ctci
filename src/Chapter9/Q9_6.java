package Chapter9;
/*
 * Given a matrix in which each row and each column is sorted, write a method to find an element in it.
 * Rows are sorted left to right in ascending order. Columns are sorted top to bottom in ascending order.
 * Matrix is of size MxN.
 */

public class Q9_6 {
	public static boolean findElement(int[][] mat, int x) {
		int M = mat.length;
		int N = mat[0].length;
		int row = 0, col = N-1; //Searching starts from first row and last column
		
		while(row < M && col >= 0) {
			if(mat[row][col] == x) {
				return true;
			}else if(mat[row][col] > x) {
				//If current element is greater than the element to be searched move to the previous column 
				col--;
			}else {
				//If current element is less than the element to be searched move to the next row
				row++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] m = {{15,20,40, 85},
                {20,35,80, 95},
                {30,55,95, 105},
                {40,80,100,120}};
		System.out.println(findElement(m, 80));
	}

}
