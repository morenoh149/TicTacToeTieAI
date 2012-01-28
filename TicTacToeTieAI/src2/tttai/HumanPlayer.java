package tttai;

import java.util.Scanner;
import tictactoeai.Board;

public class HumanPlayer implements Player {
	int playerNum;
	String type="Human";
	
	HumanPlayer(){
	}
	
	@Override
	public tttai.Board makeMove(tttai.Board board){
		Scanner s = new Scanner(System.in);
		int move = s.nextInt();
		while(move>9||move<1){
			System.out.println("pick a valid square");
			move = s.nextInt();
		}
		if(board.board[move]=="X"||board.board[move]=="O")
			try {
				throw new Exception("square occupied!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		return board.makeMove("O", move);
	}
}
