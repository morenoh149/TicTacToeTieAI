package tictactoeai;

public class Emptyplace implements place {
	private int hold=0;

	
	public Emptyplace(){
	}

	@Override
	public boolean equals(place place) {
		return this.getPlace()==place.getPlace();
	}

	@Override
	public int getPlace() {
		return hold;
	}

	@Override
	public String printPlace() {
		return " ";
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

}
