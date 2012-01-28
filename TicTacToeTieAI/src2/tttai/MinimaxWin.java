package tttai;

public class MinimaxWin implements Player {
	boolean maxTurn;
	boolean firstTurn;
	String lastmove;
	Node root;
	Node currentNode;

	MinimaxWin(){
		maxTurn=true;
		firstTurn=true;
	}
	public String getType(){
		return "Minimax-Win";
	}
	@Override
	public Board makeMove(Board b) {
		if(firstTurn){
			root = new Node(b, null);
			minimax(root, maxTurn, firstTurn);
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
					int branch = minimax(currentNode, maxTurn, firstTurn);
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
			return n.score;
		}
	}
	@Override
	public String getMove() {
		return lastmove;
	}
}
