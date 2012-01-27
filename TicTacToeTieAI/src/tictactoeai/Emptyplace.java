package tictactoeai;

public class Emptyplace implements Place {
	private int hold=0;
	private int square;

	public Emptyplace(int location){
		this.square=location;
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
		return Integer.valueOf(square).toString();
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

}
