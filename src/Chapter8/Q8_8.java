package Chapter8;


/*
 * Write an algorithm to place eight queens on a chess board so that none of them share the same row, column or diagonal.
 */
public class Q8_8 {
	static int[][] board = new int[8][8];
	public static boolean arrangeQueens(int col) {
		if(col == 8) {
			//All queens are placed
			return true;
		}
		 /* Consider this column and try placing
        this queen in all rows one by one */
		for(int i=0;i<8;i++) {
			if(isSafe(i, col)) {
				//Place the queen
				board[i][col] = 1;
				//Recur to place rest of the queens
				if(arrangeQueens(col+1)) {
					return true;
				}
				//Else backtrack
				board[i][col] = 0;
			}
		}
		return false;
	}
	
	static boolean isSafe(int row, int col)
    {
        int i, j;
 
        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
 
        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;
 
        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<8; i++, j--)
            if (board[i][j] == 1)
                return false;
 
        return true;
    }
	
	private static void printBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		arrangeQueens(0);
		printBoard();
	}
}
