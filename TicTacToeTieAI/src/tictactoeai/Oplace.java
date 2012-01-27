package tictactoeai;

public class Oplace implements place {
	private int hold = 1;
	
	public Oplace(){
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
		return "O";
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
