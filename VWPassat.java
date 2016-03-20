
public class VWPassat extends VW {

	private final static double cubicCapacity = 1.9;

	public VWPassat(String chassisNumber, int fuelTank, String fuelType, int numberOfGears, float currentFuelAmmount) {
		super(chassisNumber, fuelTank, fuelType, numberOfGears, currentFuelAmmount, cubicCapacity);
	}

	@Override
	public void getConsumedFuelByShift(int gear, double distance) {
		switch (gear) {
		case 1:
			drivenConsumedFuel = (18 * distance / 100);
		case 2:
			drivenConsumedFuel = (15 * distance / 100);
		case 3:
			drivenConsumedFuel = (12.5 * distance / 100);
		case 4:
			drivenConsumedFuel = (9 * distance / 100);
		case 5:
			drivenConsumedFuel = (5 * distance / 100);
		}
		consumedFuel += drivenConsumedFuel;
	}

	@Override
	public float getAvailableFuel() {

		currentFuelAmmount = (float) (currentFuelAmmount - (traveledDistance * getAverageFuelConsumption() / 100));
		return currentFuelAmmount;

	}

}
