package tttai;

public interface Player {
	/**
	 * modifies the global board with a move
	 */
	Board makeMove(Board board);
	
	String toString();
	String getType();
	String getMove();
}
