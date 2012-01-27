package tictactoeai;

public interface Place {
	boolean equals(Place place);
	/**
	 * returns the hold value for the place,
	 * 0 empty
	 * 1 x
	 * 2 o
	 * @return
	 */
	int getPlace();
	String printPlace();
	boolean isEmpty();
}
