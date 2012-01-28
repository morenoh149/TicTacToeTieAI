package tttai;

public interface Player {
	public String type="null";
	/**
	 * modifies the global board with a move
	 */
	Board makeMove(Board board);
	
	String toString();
}
