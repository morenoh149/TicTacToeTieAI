package tictactoeai;

public class MinimaxWin implements Player {
	private Node tree;
	private Node activeNode;
	private boolean firstMove;

	
	MinimaxWin(){
		System.out.println("minimax made");
		tree = new Node(1);
		activeNode=tree;
		firstMove=true;
		System.out.println("minimax made");
	}
	

	@Override
	public String getType() {
		return "Minimax-Win";
	}

	public String toString(){
		Node temp=activeNode;
		String ret = "";
		boolean ctl=true;
		while(ctl){
			if(temp==null){
				ctl=false;
			}
			if(temp!=null){
				ret = ret + temp.getState().toString();
				if(temp.getParent()!=null){
					temp=temp.getParent();
				}
			}
		}
		return ret;
	}

	@Override
	public void makeMove(Board board) {
		System.out.println("making move");
		if(firstMove){
			int score=activeNode.getScore();
			for(Node n: activeNode.getChildren()){
				if(n.getScore()==score){
					activeNode=n;
					break;
				}
			}
			board.makeMove(1, activeNode.getMovement());
			this.firstMove = false;
		}else{
			System.out.println("not first move");
			for(Node n: activeNode.getChildren()){
				System.out.println("checking nodes");
				if(n.getState().equals(board)){
					System.out.println("state equals board");
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
