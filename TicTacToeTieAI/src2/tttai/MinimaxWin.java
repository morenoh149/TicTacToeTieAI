package tttai;

import java.util.Collections;

public class MinimaxWin implements Player {
	boolean maxTurn;
	boolean firstTurn;
	public String type = "Minimax-Win";
	Node root;
	Node currentNode;

	MinimaxWin(){
		maxTurn=true;
		firstTurn=true;
	}
	@Override
	public Board makeMove(Board b) {
		if(firstTurn){
			System.out.println("first turn");
			root = new Node(b, null);
			minimax(root, maxTurn, firstTurn);
			currentNode = root.children.get((int)(Math.random()*10)%9);
			this.firstTurn=false;
			return currentNode.board;
		}
		else{
			for(Node c: currentNode.children){
				if(b.equals(c.board)){
					currentNode = c;
					maxTurn=true; firstTurn=false;
					System.out.println("currentnode children are:");
					int i=0;
					for(Node d: currentNode.children){
						System.out.println(d.score);
						System.out.println(i++);
						System.out.println(d.board.toString());
					}
					int branch = minimax(currentNode, maxTurn, firstTurn);
					System.out.println("branch found: "+branch);
					if(currentNode != currentNode.find(branch))
						System.out.println("moving to lower node");
					currentNode = currentNode.find(branch);//set the currentNode to the one indicated by minimax
					return currentNode.board;
				}
			}
			return null;
		}
	}
	/**
	 * runs minimax algorithm
	 */
	public int minimax(Node n, boolean maxTurn, boolean makeTree){
		if(n.board.isOver()){
			n.score = n.score("win");
			return n.score;
		}
		if(makeTree){
			if(maxTurn){
				n.makeChildren("X");
				int max = -100;
				for(Node c: n.children){
					int minimaxVal = minimax(c, false, true);
					if(minimaxVal>max)
						max = minimaxVal;
				}
				n.score = max;
				return max;
			}
			else{
				n.makeChildren("O");
				int min = 100;
				for(Node c: n.children){
					int minimaxVal = minimax(c, true, true);
					if(minimaxVal<min)
						min = minimaxVal;
				}
				n.score = min;
				return min;
			}
		}
		else{
			System.out.println("score of board is: "+n.score);
			return n.score;
		}
	}
}
