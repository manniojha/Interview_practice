package Practicle;

import java.util.Scanner;

public class TicTacToe {
	private String[][] board;
	private static final int ROWS = 3;
	private static final int COL = 3;
	private String regex = "\\s{3}";
	
	public TicTacToe() {
		board = new String[ROWS][COL];
	}
	public void initializeBoard() {
		for(int i=0; i < ROWS ; i++ ) {
			for(int j = 0; j < COL; j++) {
				board[i][j] = "   ";
			}
		}
	}
	public void setPlay(int i, int j, String player) {
		if(this.board[i][j].matches(regex)) {
			board[i][j] = " "+player + " ";
		}
	}
	public boolean isGameOver() {
		//Checking ROWS
		for(int i=0;i < ROWS;i++) {
			if(!board[i][0].matches(regex) && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
				return true;
			}
		}
		//Checking COLOUMS
		for(int j=0;j < COL; j++) {
			if(!board[0][j].matches(regex) && board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j])) {
				return true;
			}
		}
		//Checking Diagonals
		if(!board[0][0].matches(regex) && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
			return true;
		}
		if(!board[0][2].matches(regex) && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
			return true;
		}
		
		return false;
		
	}
	public String printBoard() {
		String strBoard = "";
		for(int i=0; i < ROWS ; i++ ) {
			for(int j = 0; j < COL; j++) {
				if(j  != COL-1)
					strBoard += board[i][j] + "!";
				else
					strBoard += board[i][j];
			}
			if( i != COL-1)
			      strBoard += "\n---+---+---\n";
		}
		return strBoard;
	}
	public void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) 
    { 
        if (n == 1) 
        { 
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod); 
            return; 
        } 
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod); 
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod); 
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod); 
    } 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		game.initializeBoard();
		String player = "X";
		do {
			System.out.println(game.printBoard());
			try {
				System.out.print("Enter Co-ordinates of ROW : ");
				int row = input.nextInt();
				System.out.print("Enter Co-ordinates of COLOUMS : ");
				int col = input.nextInt();
				game.setPlay(row,col, player);
			} catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			if(game.isGameOver()) {
				System.out.println(game.printBoard() + "\n" + player + " wins!!!");
				break;
			}
			if(player == "X") {
				player = "0";
			}else {
				player = "X";
			}
		}while(true);
		/* int n = 4; // Number of disks 
		 TicTacToe game = new TicTacToe();
		 game.towerOfHanoi(n, 'A', 'C', 'B');*/
	}
}
