package Chapter19;
/*
 * Design an algorithm to figure out if someone has won in a game of tic-tac-toe.
 * Assumption: Board is 3*3 (Generic code can be derived by replacing 3 with N and 2 with N-1)
 */
public class Q19_2 {
	public static boolean win(char[][] board, char playerId, int i, int j) {
		//Check row
		boolean check = true;
		for(int k=0;k<3;k++) {
			if(board[i][k] != playerId) {
				check = false;
				break;
			}
		}
		if(check) return true;
		
		//Check Column
		check = true;
		for(int k=0;k<3;k++) {
			if(board[k][j] != playerId) {
				check = false;
				break;
			}
		}
		if(check) return true;
		
		//Check diagonal
		if((i==j) || (i==2 && j==0) || (i==0 && j==2)) {
			check = true;
			for(int k=0;k<3;k++) {
				if(board[k][k] != playerId) {
					check = false;
					break;
				}
			}
			if(check) return true;
			check = true;
			for(int k=0;k<3;k++) {
				if(board[k][2-k] != playerId) {
					check = false;
					break;
				}
			}
			if(check) return true;
		}
		return false;
	}
	
	public static void printBoard(char[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(((board[i][j] == 0) ? "-" : board[i][j]) + " ");
			}
			System.out.print("\n");
		}
		System.out.print("******************");
		System.out.print("\n");
	}
	public static void main(String[] args) {
		//Code to play game
		char[][] board = new char[3][3];
		int i,j;
		char playerId;
		i=0; j=0; playerId = 'A';
		board[i][j] = playerId;
		printBoard(board);
		if(win(board, playerId, i, j)) {
			System.out.println("Player " + playerId + " won!!!!");
			return;
		}
		
		i=0; j=1; playerId = 'B';
		board[i][j] = playerId;
		printBoard(board);
		if(win(board, playerId, i, j)) {
			System.out.println("Player " + playerId + " won!!!!");
			return;
		}
		
		i=1; j=1; playerId = 'A';
		board[i][j] = playerId;
		printBoard(board);
		if(win(board, playerId, i, j)) {
			System.out.println("Player " + playerId + " won!!!!");
			return;
		}
		
		i=1; j=2; playerId = 'B';
		board[i][j] = playerId;
		printBoard(board);
		if(win(board, playerId, i, j)) {
			System.out.println("Player " + playerId + " won!!!!");
			return;
		}
		
		i=2; j=2; playerId = 'A';
		board[i][j] = playerId;
		printBoard(board);
		if(win(board, playerId, i, j)) {
			System.out.println("Player " + playerId + " won!!!!");
			return;
		}
	}
}
