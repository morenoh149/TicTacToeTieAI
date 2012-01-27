package tictactoeai;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Place> board;
	
	public Board(){
		board = new ArrayList<Place>(9); 
		for(int i=0; i<9; i++){
			board.add(new Emptyplace());
		}
	}
	public List<Place> getBoard(){
		return board;
	}
	public void move(int player, int space){
		if(player==1){
			board.add(space, new Oplace());
		}
		if(player==2){
			board.add(space, new Xplace());
		}
	}
}
