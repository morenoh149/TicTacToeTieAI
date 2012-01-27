package tictactoeai;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<place> board;
	
	public Board(){
		board = new ArrayList<place>(); 
		for(int i=0;i==9;i++){
			board.add(new Emptyplace());
		}
	}
	public List<place> getBoard(){
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
