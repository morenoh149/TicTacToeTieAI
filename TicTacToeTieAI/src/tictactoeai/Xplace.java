package tictactoeai;


public class Xplace implements place {
	private int hold=2;

	public Xplace(){
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
		return "X";
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
