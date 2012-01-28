package tttai;

public class AlphaBetaPruning implements Player{
	boolean maxTurn;
	boolean firstTurn;
	String lastmove;
	Node root;
	Node currentNode;
	
	AlphaBetaPruning(){
		maxTurn=true;
		firstTurn=true;
	}
	
	@Override
	public Board makeMove(Board b) {
		if(firstTurn){
			root = new Node(b, null);
			minimax(root, maxTurn, firstTurn, -100, 100);
			currentNode = root.children.get((int)(Math.random()*10)%9);
			this.firstTurn=false;
			lastmove = b.diff(currentNode.board);
			return currentNode.board;
		}
		else{
			for(Node c: currentNode.children){
				if(b.equals(c.board)){
					currentNode = c;
					maxTurn=true; firstTurn=false;
					int branch = minimax(currentNode, maxTurn, firstTurn, -100, 100);
					currentNode = currentNode.find(branch);//set the currentNode to the one indicated by minimax
					lastmove = b.diff(currentNode.board);
					return currentNode.board;
				}
			}
			return null;
		}
	}
	/**
	 * runs minimax algorithm
	 */
	public int minimax(Node n, boolean maxTurn, boolean makeTree, int alpha, int beta){
		if(n.board.isOver()){
			n.score = n.score("win");
			return n.score;
		}
		if(makeTree){
			if(maxTurn){
				n.makeChildren("X");
				for(Node c: n.children){
					alpha = Math.max(alpha, minimax(c, false, true, alpha, beta));
					if(beta <= alpha)
						break;
				}
				n.score = alpha;
				return alpha;
			}
			else{
				n.makeChildren("O");
				for(Node c: n.children){
					beta = Math.min(beta, minimax(c, true, true, alpha, beta));
					if(beta <= alpha)
						break;
				}
				n.score = beta;
				return beta;
			}
		}
		else{
			return n.score;
		}
	}
	@Override
	public String getType() {
		return "Minimax-WinAlphaBetaPrune";
	}

	@Override
	public String getMove() {
		return lastmove;
	}

}
