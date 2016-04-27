package ro.sci.java.dealership;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ro.sci.java.vehicle.Car;
import ro.sci.java.vehicle.Car.CarComparator;

/**
 * 
 * @author Timy
 *
 */
public class ClientAccount {

	private String clientName;

	/**
	 * Constructor for ClientAccount
	 * 
	 * @param clientName
	 */
	public ClientAccount(String clientName) {
		super();
		this.clientName = clientName;
	}

	private List<Car> clientCarList = new ArrayList<>(); // List which holds
															// client cars.

	/**
	 * Add car to clientCarList.
	 * 
	 * @param car
	 */
	public void addCarToFleet(Car car) {
		clientCarList.add(car);
	}

	/**
	 * Remove car from clientCarList.
	 * 
	 * @param car
	 */
	public void removeCarFromFleet(Car car) {
		clientCarList.remove(car);
	}

	/**
	 * Return the list with client cars.
	 * 
	 * @return
	 */
	public List<Car> getFleet() {
		return new ArrayList<Car>(clientCarList);
	}

	/**
	 * View client cars. - car model, year, fuel consumption.
	 */
	public void viewFleet() {
		System.out.println("--Client cars--");
		for (Car entry : clientCarList) {
			System.out.println("\n" + entry.toString());
		}
	}

	/**
	 * Method used to get a list of client cars but sorted by certain requirements.
	 * 
	 * @param sortingRule
	 *            (SORT_BY_YEAR or SORT_BY_FUEL_EFFICIENCY)
	 * @return sortedCars;
	 */
	public List<Car> myFleet(Comparator<Car> sortingRule) {
		List<Car> sortedCars = getFleet();
		if (sortingRule.equals(CarComparator.SORT_BY_YEAR)) {
			Collections.sort(sortedCars, CarComparator.SORT_BY_YEAR);
		} else {
			Collections.sort(sortedCars, CarComparator.SORT_BY_FUEL_EFFICIENCY);
		}
		return sortedCars;
	}

	// Getter & setter.
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

}
