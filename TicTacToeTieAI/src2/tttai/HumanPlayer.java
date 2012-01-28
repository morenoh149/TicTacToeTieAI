package tttai;

import java.util.Scanner;

public class HumanPlayer implements Player {
	int playerNum;
	String lastmove;
	
	HumanPlayer(){
	}
	
	public String getType(){
		return "Human";
	}
	@Override
	public Board makeMove(Board board){
		Scanner s = new Scanner(System.in);
		int move = s.nextInt();
		while(move>9||move<1){
			System.out.println("pick a valid square");
			move = s.nextInt();
		}
		if(board.board[move]=="X"||board.board[move]=="O"){
			try {
				throw new Exception("square occupied!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		lastmove = String.valueOf(move);
		return board.makeMove("O", move);
	}

	@Override
	public String getMove() {
		return lastmove;
	}
}
