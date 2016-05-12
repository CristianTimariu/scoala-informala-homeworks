package ro.sci.booking;

public class RoomFare {

	private double value;
	private Season season;

	/**
	 * Constructor without season.
	 * 
	 * @param value
	 */
	public RoomFare(double value) {
		super();
		this.value = value;
	}

	public RoomFare() {
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public RoomFare createRoomFare(int value, Season season) {
		RoomFare roomFare = new RoomFare();
		roomFare.setSeason(season);
		roomFare.setValue(value);
		return roomFare;
	}
}
