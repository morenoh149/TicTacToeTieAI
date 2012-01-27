package tictactoeai;

public class SimplePlayer implements Player{
	int playerNum;
	SimplePlayer(int num){
		playerNum=num;
	}
	/**
	 * gets the original board array inside the board class, makes a move on the first square that is empty
	 * assumes board contains at least one empty square
	 */
	@Override
	public void makeMove(Board board, int space) {
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
