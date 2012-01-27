package tictactoeai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board {
	private Place[] board;
	private boolean isWon;
	int winner;
	
	public Board(){
		board = new Place[9]; 
		for(int i=1; i<=9; i++){
			board[i] = new Emptyplace(i);
		}
		isWon=false;
		winner=0;
	}
	public Board(Place[] places){
		this.board = places;
		winner=0;
		isWon=isOver();
	}
	public Place[] getBoard(){
		return board;
	}
	public void makeMove(int player, int space){
		if(player==2){
			board[space] = new Oplace();
		}
		if(player==1){
			board[space] = new Xplace();
		}
	}
	public boolean isOver(){
		boolean full=false;
		boolean won=false;
		int empty=0;
		for(int i=1;i<=9;i++){
			if(board[i].equals(new Emptyplace(i))){
				empty=empty+1;
			}
		}
		if(empty!=0){
			full=false;
		}else{
			full=true;
		}
		if(win(1,4,7)||win(2,5,8)||win(3,6,9)||win(1,2,3)||win(4,5,6)||win(7,8,9)||win(1,5,9)||win(7,5,3)){
			won=true;
		}
		
		return full || won;
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
	private boolean win(int p1, int p2, int p3){
		if(board[p1].getPlace()==1||board[p2].getPlace()==1||board[p3].getPlace()==1){
			return true;
		}
		if(board[p1].getPlace()==2||board[p2].getPlace()==2||board[p3].getPlace()==2){
			return true;
		}
		return false;
	}
}
