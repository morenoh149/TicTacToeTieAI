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

	public String toString(){
		return "";
	}

	@Override
	public void makeMove(Board board) {
		if(firstMove){
			int score=activeNode.getScore();
			for(Node n: activeNode.getChildren()){
				if(n.getScore()==score){
					activeNode=n;
					break;
				}
			}
			board.makeMove(1, activeNode.getMovement());
		}else{
			for(Node n: activeNode.getChildren()){
				if(n.getState()==board){
					activeNode=n;
					break;
				}
			}
			int score=activeNode.getScore();
			for(Node n: activeNode.getChildren()){
				if(n.getScore()==score){
					activeNode=n;
					break;
				}
			}
			board.makeMove(1, activeNode.getMovement());
		}
		return;
	}
		

}
