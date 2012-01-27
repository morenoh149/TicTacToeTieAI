package tictactoeai;

public interface Place {
	boolean equals(Place place);
	int getPlace();
	String printPlace();
	boolean isEmpty();
}
