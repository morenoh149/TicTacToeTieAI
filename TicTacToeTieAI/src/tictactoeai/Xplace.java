package tictactoeai;


public class Xplace implements Place {
	private int hold=1;

	public Xplace(){
	}
	
	@Override
	public boolean equals(Place place) {
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
