package ro.sci.java.vehicle;

public class VWGolf extends VW {

	public final static double cubicCapacity = 1.4;

	public VWGolf(String chassisNumber, int fuelTank, String fuelType, int numberOfGears, float fuelLevel) {
		super(chassisNumber, fuelTank, fuelType, numberOfGears, fuelLevel, cubicCapacity);
	}

	public VWGolf(String chassisNumber, Integer year, float price) {
		super(chassisNumber, year, price);
	}

	@Override
	public float getAverageFuelConsumption() {

		return (float) (consumedFuel / traveledDistance * 100 + consumedFuel * 30 / 100);
	}

	@Override
	public float getAvailableFuel() {

		currentFuelAmmount = (float) (currentFuelAmmount - (traveledDistance * getAverageFuelConsumption() / 100));
		return currentFuelAmmount;

	}

	@Override
	public String toString() {
		return "Car model: VWGolf" + "\nYear: " + getYear() + "\nFuel Consumption: "
				+ getAverageFuelConsumption();
	}

	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
