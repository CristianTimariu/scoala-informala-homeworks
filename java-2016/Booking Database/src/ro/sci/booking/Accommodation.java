package ro.sci.booking;

public class Accommodation {

	private AccommodationType type;
	private String description;
	private int maxGuests;
	private BedType bedType;

	/**
	 * Constructor for DB homework
	 * 
	 * @param type
	 * @param description
	 * @param maxGuests
	 * @param bedType
	 */
	public Accommodation(AccommodationType type, String description, int maxGuests, BedType bedType) {
		super();
		this.type = type;
		this.description = description;
		this.maxGuests = maxGuests;
		this.bedType = bedType;
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

	@Override
	public String toString() {
		return getType() + "," + getDescription() + "," + getMaxGuests() + "," + getBedType();

	}
}