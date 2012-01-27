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
	private int move;
	private List<Node> children;
	int player;
	int goal;
	boolean isMax;

	/**
	 * this constructor makes the root node of the search tree
	 * @param goal the goal state your are looking for 1 for win 0 for tie
	 */
	Node(int goal){
		this.board = new Board(); //the current or possible board
		this.score = 0; // a score based on the minimax algorithm
		this.player = 1; //the current player who CAN move this turn on this board
		this.goal=goal; //our goal value win/loss/tie
		this.isMax = false;
		this.children = new ArrayList<Node>();

		Place[] places = board.getBoard();
		for(int i=1; i<=9; i++){
			if(places[i].getPlace()==0){
				children.add(new Node(this, createBoard(places), goal, i, 1, true));
			}
		}
		this.score=getScore(children, isMax);
	}
	/**
	 * this constructor handles building chld nodes which are more complicated or could be used to dynamically assign the minimax player to the sencond position.
	 * @param parent the parent node
	 * @param board the board as the parent has it
	 * @param goal the goal state
	 * @param move the move that should be made
	 * @param player the parent's player
	 * @param isMax the boolean to control weather this is a min or max node
	 */
	Node(Node parent, Board board, int goal, int move, int player, boolean isMax){
		this.parent = parent;
		this.player = player;
		this.move=move;
		this.children = new ArrayList<Node>();
		this.board = board;
		board.makeMove(player, move);
		if(board.isOver()!=true){
			Place[] places = board.getBoard();
			for(int i=1; i<=9; i++){
				if(places[i].getPlace()==0){
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
		if(score==1&&board.whoWon()!=0){
			System.out.println("Score1 board: \n"+board.toString());
		}
	}
	/**
	 * this function generates the scores of terminal nodes
	 * @param goal the goal state
	 * @return the score of this node
	 */
	private int generateScore(int goal){
		int ret=0;
		if(goal==0){
			int a = board.whoWon();
			if(a==2){
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
			if(a==2){
				ret=-1;
			}
			if(a==0){
				ret=0;
			}
			if(a==1){
				ret=1;
			}
		}
		//System.out.println("generateScore: "+ret+"\n"+board.toString());
		return ret;
	}
	
	/**
	 * returns the score of the node
	 * @return the node's score
	 */
	
	public int getScore(){
		return score;
	}
	
	/**
	 * adds a child to the node
	 * @param child the child node to be added
	 */
	
	public void addChild(Node child){
		children.add(child);
	}
	
	/**
	 * returns the children of the node
	 * @return the List of children
	 */
	
	public List<Node> getChildren(){
		return children;
	}
	
	/**
	 * returns the node's parent
	 * @return the parent node
	 */
	
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
		int a;
		if(isMax){
			a=-1;
			for(Node n: children){
				a = Math.max(a, n.getScore());
			}
		}else{
			a=1;
			for(Node n: children){
				a = Math.min(a, n.getScore());
			}
		}
		return a;
	}
	public Node getMove(Board board) {
		int score = this.score;
		for(Node n: children){
			if(n.getScore()==score);
			return n;
		}
		return null;
	}
	public int getMovement() {
		return move;
	}

}
