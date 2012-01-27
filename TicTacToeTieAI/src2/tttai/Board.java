package tttai;

public class Board {
	String[] board = {"0","1","2","3",
			"4","5","6",
			"7","8","9"};
	int spacesFree;
	String winner;

	Board(){
		spacesFree = 9;
		winner = null;
	}
	Board(Board b, int space, String player){
		this.board = b.board;
		this.board[space] = player;
	}
	
	/**
	 * returns true if the game is over (won or full-tie)
	 */
	public boolean isOver(){
		if(spacesFree==0)
			return true;
		if(this.isWon())
			return true;
		else
			return false;
	}
	/**
	 * returns true if the board is won
	 */
	public boolean isWon(){
		if(this.testWon("X")){
			this.winner = "X";
			return true;
		}
		if(this.testWon("O")){
			this.winner = "O";
			return true;
		}
		else
			return false;
	}
	/**
	 * returns true if string is the winner
	 */
	public boolean testWon(String s){
		if(board[1]==s&&board[2]==s&&board[3]==s)
			return true;
		if(board[4]==s&&board[5]==s&&board[6]==s)
			return true;
		if(board[7]==s&&board[8]==s&&board[9]==s)
			return true;
		if(board[1]==s&&board[4]==s&&board[7]==s)
			return true;
		if(board[2]==s&&board[5]==s&&board[8]==s)
			return true;
		if(board[3]==s&&board[6]==s&&board[9]==s)
			return true;
		if(board[1]==s&&board[5]==s&&board[9]==s)
			return true;
		if(board[3]==s&&board[5]==s&&board[7]==s)
			return true;
		return false;
	}
}
