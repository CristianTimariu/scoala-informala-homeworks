public abstract class Car implements Vehicle {

	protected String chassisNumber;
	protected int fuelTank;
	protected String fuelType;
	protected int numberOfGears;
	protected float currentFuelAmmount;
	protected int gear;
	protected double traveledDistance;
	protected double drivenConsumedFuel;
	protected float consumedFuel;
	public double distance;
	public boolean turnEngineOn = false;

	public Car(String chassisNumber, int fuelTank, String fuelType, int numberOfGears, float currentFuelAmmount) {

		super();
		this.chassisNumber = chassisNumber;
		this.fuelTank = fuelTank;
		this.fuelType = fuelType;
		this.numberOfGears = numberOfGears;
		this.currentFuelAmmount = currentFuelAmmount;
	}

	// getters & setters
	public String getChassisNumber() {
		return chassisNumber;
	}

	public final void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public int getFuelTank() {
		return fuelTank;
	}

	public final void setFuelTank(int fuelTank) {
		this.fuelTank = fuelTank;
	}

	public String getFuelType() {
		return fuelType;
	}

	public final void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getNumberOfGears() {
		return numberOfGears;
	}

	public void setNumberOfGears(int numberOfGears) {
		this.numberOfGears = numberOfGears;
	}

	public double getFuelLevel() {
		return currentFuelAmmount;
	}

	public void setFuelLevel(float currentFuelAmmount) {
		this.currentFuelAmmount = currentFuelAmmount;
	}

	// methods for driving
	@Override
	public void start() {
		turnEngineOn = true;
		System.out.println("Current Fuel ammount is: " + currentFuelAmmount);
		traveledDistance = 0;
	}

	public void shiftGear(int newValue) {
		gear = newValue;
	}

	@Override
	public void drive(double distance) {

		getConsumedFuelByShift(gear, distance);
		getTotalTraveledDistance(distance);

	}

	@Override
	public void stop() {
		turnEngineOn = false;
		System.out.println("Traveled distance is: " + traveledDistance + " km");
	}

	// Fuel and Consumption methods
	public void getTotalTraveledDistance(double distance) {
		traveledDistance += distance;
	}

	public void getConsumedFuelByShift(int gear, double distance) {
		switch (gear) {
		case 1:
			drivenConsumedFuel = (20 * distance / 100);
		case 2:
			drivenConsumedFuel = (18 * distance / 100);
		case 3:
			drivenConsumedFuel = (12.5 * distance / 100);
		case 4:
			drivenConsumedFuel = (9 * distance / 100);
		case 5:
			drivenConsumedFuel = (6 * distance / 100);
		}
		consumedFuel += drivenConsumedFuel;
	}

	public float getAverageFuelConsumption() {
		return (float) (consumedFuel / traveledDistance * 100);
	}

	public float getAvailableFuel() {
		return currentFuelAmmount -= consumedFuel;
	}

	// Other methods
	public void reFuel(float fuel) {
		if (currentFuelAmmount + fuel > fuelTank) {
			System.out.println("You have reach the maximum capacity of the Fuel Tank!!!" + "You've just needed:"
					+ (fuelTank - currentFuelAmmount));
			currentFuelAmmount = fuelTank;
		} else {
			currentFuelAmmount += fuel;
		}
	}

}
