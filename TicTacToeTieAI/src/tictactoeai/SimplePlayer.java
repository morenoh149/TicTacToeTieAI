package tictactoeai;

public class SimplePlayer implements Player{
	int playerNum;
	Board board;
	SimplePlayer(int num){
		playerNum=num;
	}
	@Override
	public void makeMove(Board board) {
		this.board.makeMove(2, space);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
