package tictactoeai;

public class MinimaxWin implements Player {
	private Node tree;
	private Node activeNode;
	private boolean firstMove;

	
	MinimaxWin(){
		tree = new Node(1);
		activeNode=tree;
		firstMove=true;
	}
	

	@Override
	public String getType() {
		return "minimax-Win";
	}


	@Override
	public void makeMove(Board board) {
		if(firstMove){
			board.makeMove(1, activeNode.getMove(board, firstMove).getMovement());
			firstMove=false;	
			return;
		}
		for(Node n: activeNode.getChildren()){
			if(board.equals(n.getState())){
				activeNode=n;
			}
		}
		board.makeMove(1, activeNode.getMove(board, firstMove).getMovement());
		
	}

}
