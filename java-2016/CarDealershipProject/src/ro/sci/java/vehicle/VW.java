package ro.sci.java.vehicle;

public abstract class VW extends Car {

	public VW(String chassisNumber, int fuelTank, String fuelType, int numberOfGears, float fuelLevel,
			double cubicCapacity) {
		super(chassisNumber, fuelTank, fuelType, numberOfGears, fuelLevel);

	}

	public VW(String chassisNumber, Integer year, float price) {
		super(chassisNumber, year, price);
	}

}
