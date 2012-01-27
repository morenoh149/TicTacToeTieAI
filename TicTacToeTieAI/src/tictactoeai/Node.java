package tictactoeai;
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

	Node(int goal){
		this.board = new Board();
		this.score = 0;
		this.player = 1;
		this.goal=goal;
		Place[] places = board.getBoard();
		for(int i=1;i<9;i++){
			if(places[i].equals(new Emptyplace(i))){
				new Board()
				children.add(new Node(this, ))
			}
		}
	}
	Node(Node parent, Board board, int goal){
		this.parent = parent;
		this.children = new ArrayList<Node>();
		this.board = board;
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
}
