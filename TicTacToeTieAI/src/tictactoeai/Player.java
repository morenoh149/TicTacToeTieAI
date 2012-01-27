package tictactoeai;

public interface Player {
	/**
	 * modifies the global board with the move generated
	 */
	void makeMove(Board board, int space);
	/**
	 * returns a string representation of the type of player
	 * Minimax-Win
	 * Minimax-Tie
	 * Simple
	 * Human
	 * @return
	 */
	String getType();
}
