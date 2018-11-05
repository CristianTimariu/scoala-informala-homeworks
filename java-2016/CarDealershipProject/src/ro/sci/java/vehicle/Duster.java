package ro.sci.java.vehicle;

public class Duster extends Dacia {

	private float tireWidth; // Duster have tire width in plus, which influent's
								// the fuel consumption.

	public Duster(String chassisNumber, int fuelTank, String fuelType, int numberOfGears, float fuelLevel,
			float anvelopeWidth) {
		super(chassisNumber, fuelTank, fuelType, numberOfGears, fuelLevel);
		this.setAnvelopeWidth(anvelopeWidth);
	}

	/*
	 * Constructor used in DealerShip.
	 */
	public Duster(String chassisNumber, Integer year, float price) {
		super(chassisNumber, year, price);
	}

	/**
	 * Constructor used to test fuel efficiency sort.
	 * 
	 * @param chassisNumber
	 * @param year
	 * @param price
	 * @param averageConsumption
	 */
	public Duster(String chassisNumber, Integer year, float price, double averageConsumption) {
		super(chassisNumber, year, price, averageConsumption);
	}

	// getter & setter
	public float getAnvelopeWidth() {
		return tireWidth;
	}

	public void setAnvelopeWidth(float anvelopeWidth) {
		this.tireWidth = anvelopeWidth;
	}

	// Using different consumption
	@Override
	public float getAverageFuelConsumption() {
		if (tireWidth > 200) {
			return (float) (consumedFuel / traveledDistance * 100 + consumedFuel * 10 / 100);
		} else
			return (float) (consumedFuel / traveledDistance * 100 + consumedFuel * 5 / 100);
	}

	@Override
	public float getAvailableFuel() {

		currentFuelAmmount = (float) (currentFuelAmmount - (traveledDistance * getAverageFuelConsumption() / 100));
		return currentFuelAmmount;

	}

	@Override
	public String toString() {
		return "Car model: Duster" + "\nYear: " + getYear() + "\nFuel Consumption: " + getAverageFuelConsumption();
	}

	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
