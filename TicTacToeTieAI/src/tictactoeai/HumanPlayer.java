package tictactoeai;

import java.util.Scanner;


public class HumanPlayer implements Player{
	int playerNum;
	HumanPlayer(int num){
		playerNum=num;
	}
	@Override
	public void makeMove(Board board){
		Scanner s = new Scanner(System.in);
		int move = s.nextInt();
		while(move>9||move<1){
			try {
				throw new Exception("you're a dunce!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			move = s.nextInt();
		}
		board.makeMove(playerNum, move);
	}

	@Override
	public String getType() {
		return "Human";
	}

}
