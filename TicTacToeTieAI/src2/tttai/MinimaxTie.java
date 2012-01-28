package tttai;

public class MinimaxTie implements Player {
	boolean maxTurn;
	boolean firstTurn;
	Node root;
	Node currentNode;
	String lastmove;

	MinimaxTie(){
		maxTurn=true;
		firstTurn=true;
	}
	public String getType(){
		return "Minimax-Tie";
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
					System.out.println("current node children: ");
					for(Node d: c.children){
						System.out.println("score: "+d.score);
						System.out.println("sum: "+d.sum);
						System.out.println(d.board.toString());
					}
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
			n.sum = n.score("tie");
			return n.sum;
		}
		if(makeTree){
			if(maxTurn){
				n.makeChildren("X");
				int max = -100;
				int sum = 0;
				for(Node c: n.children){
					int minimaxVal = minimax(c, false, true);
					if(minimaxVal>0)
						sum++;
					if(minimaxVal>max)
						max = minimaxVal;
				}
				n.score = max;
				n.sum = sum;
				return sum;
			}
			else{
				n.makeChildren("O");
				int min = 100;
				int sum = 0;
				for(Node c: n.children){
					int minimaxVal = minimax(c, true, true);
					if(minimaxVal>0)
						sum++;
					if(minimaxVal<min)
						min = minimaxVal;
				}
				n.score = min;
				n.sum = sum;
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
