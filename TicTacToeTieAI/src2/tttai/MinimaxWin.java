package tttai;

import java.util.Collections;

public class MinimaxWin implements Player {
	boolean maxTurn=true;
	@Override
	public void makeMove(Board b) {
		Node root = new Node(b, null);
	    minimax(root);
	}
	/**
	 * runs minimax algorithm
	 */
	public int minimax(Node n){
		if(n.board.isOver())
			return n.score();
		n.makeChildren("X");
		if(maxTurn){
			return Collections.max(minimax(n.children));
		}
		else{
			return Collections.min(minimax(n.children));
		}
	}
}
