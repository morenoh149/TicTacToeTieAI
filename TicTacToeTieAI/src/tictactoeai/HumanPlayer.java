package tictactoeai;


public class HumanPlayer implements Player{
	int playerNum;
	HumanPlayer(int num){
		playerNum=num;
	}
	@Override
	public void makeMove(Board board, int move) {
		board.makeMove(playerNum, move);
	}

	@Override
	public String getType() {
		return "Human";
	}

}
