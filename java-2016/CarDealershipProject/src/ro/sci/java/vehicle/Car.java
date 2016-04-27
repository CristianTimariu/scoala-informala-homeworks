package ro.sci.java.vehicle;

import java.util.Comparator;

public abstract class Car implements Vehicle, Comparable<Car> {

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
	private Integer year;
	private float price;
	private double averageConsumption; //<-- USED FOR TEST
	/*
	 * I try comparator in different ways. In comments it was used same as in
	 * MusicStoreApp. After that I use a comparator in enum in order to choose
	 * sorting rule, hope that's ok.
	 */
	// public static final Comparator<Car> SORT_BY_AGE = new Comparator<Car>() {
	//
	// @Override
	// public int compare(Car o1, Car o2) {
	// return o1.getYear().compareTo(o2.getYear());
	// }
	// };

	public enum CarComparator implements Comparator<Car> {
		SORT_BY_YEAR {
			public int compare(Car car1, Car car2) {
				return car1.getYear().compareTo(car2.getYear());
			}
		},

		SORT_BY_FUEL_EFFICIENCY {
			public int compare(Car car1, Car car2) {
				return Double.compare(car1.getAverageConsumption(), car2.getAverageConsumption());
			}
		};
	}

	/*
	 * Constructor for other homework
	 */
	public Car(String chassisNumber, int fuelTank, String fuelType, int numberOfGears, float currentFuelAmmount) {

		super();
		this.chassisNumber = chassisNumber;
		this.fuelTank = fuelTank;
		this.fuelType = fuelType;
		this.numberOfGears = numberOfGears;
		this.currentFuelAmmount = currentFuelAmmount;
	}

	/**
	 * Constructor for Dealership class
	 * 
	 * @param chassisNumber
	 * @param year
	 * @param price
	 */
	public Car(String chassisNumber, Integer year, float price) {
		this.chassisNumber = chassisNumber;
		this.year = year;
		this.price = price;
	}

	/**
	 * Constructor used to test fuel efficiency sort.
	 * 
	 * @param chassisNumber
	 * @param year
	 * @param price
	 * @param averageConsumption
	 */
	public Car(String chassisNumber, Integer year, float price, double averageConsumption) {
		this.chassisNumber = chassisNumber;
		this.year = year;
		this.price = price;
		this.averageConsumption = averageConsumption;
	}

	// getters & setters
	public double getAverageConsumption() {
		return averageConsumption;
	}

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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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

	/**
	 * Method that calculates car average consumption.
	 * 
	 * @return
	 */
	public float getAverageFuelConsumption() {
		return (float) (consumedFuel / traveledDistance * 100);
	}

	/**
	 * Calculates the remaining fuel.
	 * 
	 * @return
	 */
	public float getAvailableFuel() {
		return currentFuelAmmount -= consumedFuel;
	}

	/**
	 * Adds fuel in fuelTank.
	 * 
	 * @param fuel
	 */
	public void reFuel(float fuel) {
		if (currentFuelAmmount + fuel > fuelTank) {
			System.out.println("You have reach the maximum capacity of the Fuel Tank!!!" + "You've just needed:"
					+ (fuelTank - currentFuelAmmount));
			currentFuelAmmount = fuelTank;
		} else {
			currentFuelAmmount += fuel;
		}
	}

	@Override
	public String toString() {
		return "Car model: " + getClass() + "\nYear: " + getYear() + "\nFuel Consumption: "
				+ getAverageFuelConsumption();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(averageConsumption);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((chassisNumber == null) ? 0 : chassisNumber.hashCode());
		result = prime * result + fuelTank;
		result = prime * result + ((fuelType == null) ? 0 : fuelType.hashCode());
		result = prime * result + gear;
		result = prime * result + numberOfGears;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + (turnEngineOn ? 1231 : 1237);
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (Double.doubleToLongBits(averageConsumption) != Double.doubleToLongBits(other.averageConsumption))
			return false;
		if (chassisNumber == null) {
			if (other.chassisNumber != null)
				return false;
		} else if (!chassisNumber.equals(other.chassisNumber))
			return false;
		if (fuelTank != other.fuelTank)
			return false;
		if (fuelType == null) {
			if (other.fuelType != null)
				return false;
		} else if (!fuelType.equals(other.fuelType))
			return false;
		if (gear != other.gear)
			return false;
		if (numberOfGears != other.numberOfGears)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (turnEngineOn != other.turnEngineOn)
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
}
