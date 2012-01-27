package tictactoeai;

public interface place {
	boolean equals(place place);
	int getPlace();
	String printPlace();
	boolean isEmpty();
}
