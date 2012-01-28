package tttai;

import java.util.*;

public class Node {
	Board board;
	Node parent;
	int score;
	List<Node> children;

	Node(Board board, Node parent){
		this.parent = parent;
		this.board = board;
		children = new ArrayList<Node>();
	}
	/**
	 * makes all possible next moves for next depth
	 */
	public void makeChildren(String player){
		for(int i=1; i<=9; i++){
			if(board.board[i]!="X"&&board.board[i]!="O"){
				children.add(new Node(new Board(this.board, i, player), this));
			}
		}
	}
	/**
	 * returns the value of this node, 1 for x win, -1 for o win, 0 for draw
	 * should only be run on terminal nodes
	 */
	public int score(String strategy){
		if(strategy.equals("win")){
			if(board.testWon("X"))
				return 1;
			if(board.testWon("O"))
				return -1;
			return 0;
		}
		else{
			if(board.isWon()){
				return -1;
			}
			return 1;
		}
	}
	/**
	 * takes a branch value 1, 0 -1 and returns one of the children that has that value
	 * null if no such value found
	 */
	public Node find(int branch){
		for(Node c: this.children){
			if(c.score==branch)
				return c;
		}
		System.out.println("no such branch found, returning this");
		return this;
	}
}
