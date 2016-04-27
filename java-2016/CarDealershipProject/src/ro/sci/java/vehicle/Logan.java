package ro.sci.java.vehicle;

public class Logan extends Dacia {

	private boolean airCondition;

	// Logan can have Air Condition, but influent's the consumption. If not
	// consumption will be "standard" from Car class.

	public Logan(String chassisNumber, int fuelTank, String fuelType, int numberOfGears, float fuelLevel,
			boolean airCondition) {
		super(chassisNumber, fuelTank, fuelType, numberOfGears, fuelLevel);

	}

	/*
	 * Constructor used for DealerShip.
	 */
	public Logan(String chassisNumber, Integer year, float price) {
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
	public Logan(String chassisNumber, Integer year, float price, double averageConsumption) {
		super(chassisNumber, year, price, averageConsumption);
	}

	// getter & setter
	public boolean isAirCondition() {
		return airCondition;
	}

	public void setAirCondition(boolean airCondition) {
		this.airCondition = airCondition;
	}

	// Using different consumption
	@Override
	public float getAverageFuelConsumption() {
		if (airCondition == true) {
			return (float) (consumedFuel / traveledDistance * 100 + consumedFuel * 20 / 100);
		} else
			return (float) (consumedFuel / traveledDistance * 100);
	}

	@Override
	public float getAvailableFuel() {

		currentFuelAmmount = (float) (currentFuelAmmount - (traveledDistance * getAverageFuelConsumption() / 100));
		return currentFuelAmmount;

	}

	@Override
	public String toString() {
		return "Car model: Logan" + "\nYear: " + getYear() + "\nFuel Consumption: " + getAverageFuelConsumption();
	}

	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
