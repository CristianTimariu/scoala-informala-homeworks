
public class VWGolf extends VW {

	public final static double cubicCapacity = 1.4;

	public VWGolf(String chassisNumber, int fuelTank, String fuelType, int numberOfGears, float fuelLevel) {
		super(chassisNumber, fuelTank, fuelType, numberOfGears, fuelLevel, cubicCapacity);
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

}
