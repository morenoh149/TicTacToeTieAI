package tictactoeai;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Our tree is a collection of Nodes. The search strategy loosely keeps track of it's own location
 * in the tree by traversing node by node.
 * @author harry moreno
 * @author ben leone
 */
public class Node{
	private int score;	// 1 if player 1 (us) wins, 0 if tie, -1 if player 2 (opponent) wins
	private Board board;
	private Node parent;
	private List<Node> children;
	int player;
	int goal;
	boolean isMax;

	Node(int goal){
		this.board = new Board(); //the current or possible board
		this.score = 0; // a score based on the minimax algorithm
		this.player = 1; //the current player who CAN move this turn on this board
		this.goal=goal; //our goal value win/loss/tie
		this.isMax = true;

		Place[] places = board.getBoard();
		for(int i=1;i<9;i++){
			if(places[i].equals(new Emptyplace(i))){
				children.add(new Node(this, createBoard(places), goal, i, 2, false));
			}
		}
		this.score=getScore(children, isMax);
	}
	Node(Node parent, Board board, int goal, int move, int player, boolean isMax){
		this.parent = parent;
		this.player = player;
		this.children = new ArrayList<Node>();
		this.board = board;
		board.makeMove(player, move);
		if(board.isOver()!=true){
			Place[] places = board.getBoard();
			for(int i=1;i<9;i++){
				if(places[i].equals(new Emptyplace(i))){
					if(this.player==1){
						children.add(new Node(this, createBoard(places), goal, i, 2, false));
					}else{
						children.add(new Node(this, createBoard(places), goal, i, 1, true));
					}
				}
			}
			this.score=getScore(children, isMax);
		}else{
			score=generateScore(goal);
		}
	}
	private int generateScore(int goal){
		int ret=0;
		if(goal==0){
			int a = board.whoWon();
			if(a==-1){
				ret=-1;
			}
			if(a==0){
				ret=1;
			}
			if(a==1){
				ret=-1;
			}

		}else{
			int a = board.whoWon();
			if(a==-1){
				ret=-1;
			}
			if(a==0){
				ret=0;
			}
			if(a==1){
				ret=1;
			}
		}
		return ret;
	}
	public int getScore(){
		return score;
	}
	public void addChild(Node child){
		children.add(child);
	}
	public List<Node> expand(){
		return children;
	}
	public Node getParent(){
		return parent;
	}
	public Board getState(){
		return this.board;
	}
	public String toString(){
		return this.board.toString();
	}
	public boolean eqauls(Board b) {
		return this.getState().equals(b);
	}
	private Board createBoard(Place[] board){
		Place[] places = board.clone();
		return new Board(places);
	}
	private int getScore(List<Node> children, boolean isMax){
		int a=0;
		if(isMax){
			for(Node n: children){
				a = Math.max(a, n.getScore());
			}
		}else{
			for(Node n: children){
				a = Math.min(a, n.getScore());
			}
		}
		return a;
	}

}
