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
			System.out.println("pick a valid square");
			move = s.nextInt();
		}
		if(board.getBoard()[move].getPlace()!=0)
			try {
				throw new Exception("square occupied!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		board.makeMove(playerNum, move);
	}

	@Override
	public String getType() {
		return "Human";
	}

}
