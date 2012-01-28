package tttai;

public class SimplePlayer implements Player {
	String type = "SimplePlayer";
	/**
	 * gets the original board array inside the board class, makes a move on the first square that is empty
	 * assumes board contains at least one empty square
	 */
	@Override 
	public Board makeMove(Board board) {
		String[] thisboard = board.board;
		for(int i=1; i<=9; i++){
			if((!(thisboard[i].equals("X")))&&
					(!(thisboard[i].equals("O")))){
				return board.makeMove("O",i);
			}
		}
		return board;
	}
}