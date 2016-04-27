package ro.sci.java.vehicle;

public abstract class Dacia extends Car {

	public Dacia(String chassisNumber, int fuelTank, String fuelType, int numberOfGears, float fuelLevel) {
		super(chassisNumber, fuelTank, fuelType, numberOfGears, fuelLevel);

	}

	/*
	 * Constructor used for DealerShip.
	 */
	public Dacia(String chassisNumber, Integer year, float price) {
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
	public Dacia(String chassisNumber, Integer year, float price, double averageConsumption) {
		super(chassisNumber, year, price, averageConsumption);
	}

}
