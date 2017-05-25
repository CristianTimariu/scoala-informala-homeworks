package ro.sci.booking;

public class Accommodation {

	private String roomID;
	private AccommodationType type;
	private String description;
	private int maxGuests;
	private BedType bedType;
	private RoomFare fare;

	/**
	 * Accommodation Constructor.
	 * 
	 * @param roomID
	 * @param type
	 * @param description
	 * @param maxGuests
	 * @param bedType
	 * @param fare
	 */
	public Accommodation(String roomID, AccommodationType type, String description, int maxGuests, BedType bedType,
			RoomFare fare) {
		super();
		this.roomID = roomID;
		this.type = type;
		this.description = description;
		this.maxGuests = maxGuests;
		this.bedType = bedType;
		this.fare = fare;
	}

	public Accommodation() {
	}

	public AccommodationType getType() {
		return type;
	}

	public void setType(AccommodationType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxGuests() {
		return maxGuests;
	}

	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}

	public BedType getBedType() {
		return bedType;
	}

	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}

	public RoomFare getFare() {
		return fare;
	}

	public void setFare(RoomFare fare) {
		this.fare = fare;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public Accommodation createNewRoom(AccommodationType type, RoomFare fair) {
		Accommodation accomodation = new Accommodation();
		accomodation.setType(type);
		accomodation.setFare(fair);
		return accomodation;
	}

	@Override
	public String toString() {
		return getRoomID() + "," + getType() + "," + getDescription() + "," + getMaxGuests() + "," + getBedType() + ","
				+ getFare().getValue();
	}

}