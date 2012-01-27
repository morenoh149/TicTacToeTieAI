package tictactoeai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board {
	private Place[] board;
	private int numMovesMade;
	
	public Board(){
		numMovesMade=0;
		board = new Place[9]; 
		for(int i=1; i<=9; i++){
			board[i] = new Emptyplace(i);
		}
	}
	public Place[] getBoard(){
		return board;
	}
	public void makeMove(Player player, int space){
		if(player.getType()=="Minimax-Win" ||
				player.getType()=="Minimax-Tie"){
			board[space] = new Oplace();
			numMovesMade++;
		}
		if(player.getType()=="Minimax-Win" ||
				player.getType()=="Minimax-Tie"){
			board[space] = new Xplace();
			numMovesMade++;
		}
	}
	public boolean isOver(){
		if(numMovesMade==9){
			return true;
		}
		else{
			return false;
		}
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=9; i++){
			sb.append(board[i]+" ");
			if(i%3==0){
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
