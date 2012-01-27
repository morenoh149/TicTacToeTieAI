package tttai;

public interface Player {
	/**
	 * modifies the global board with a move
	 */
	void makeMove(Board board);
	
	String toString();
}
