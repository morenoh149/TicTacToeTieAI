package tictactoeai;

public class SimplePlayer implements Player{
	int playerNum;
	SimplePlayer(int num){
		playerNum=num;
	}
	@Override
	public void makeMove(Board board) {
		Place[] array = board.getBoard();
		for(int i=1; i<=9; i++){
			if(array[i].getPlace()==0){
				board.makeMove(2, i);
				break;
			}
		}
	}

	@Override
	public String getType() {
		return "Simple";
	}

}
