package ro.sci.java.dealership;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import ro.sci.java.dealership.exceptions.CarNotFoundException;
import ro.sci.java.dealership.exceptions.IncorrectBankAccountException;
import ro.sci.java.dealership.exceptions.InsufficientFoundsException;
import ro.sci.java.vehicle.Car;

public class CarDealership {

	private String dealershipName;
	private BankAccount carDealearshipBankAccount;

	private HashSet<Car> carsInStock = new HashSet<>(); // Cars in DealerShip
	// Map where we keep Car prices by chassisNumber
	public HashMap<String, Float> priceCatalog = new HashMap<>();
	// LinkedHashMap of client accounts where the key is Client ID;
	private HashMap<String, ClientAccount> clientAccounts = new LinkedHashMap<>();

	/**
	 * Constructor for CarDealership.
	 */
	public CarDealership(String dealershipName) {
		this.setDealershipName(dealershipName);
	}

	/**
	 * Method used to add car in DealerShip stock. It also set car price in the
	 * priceCatalog map.
	 */
	public void addToStock(Car car, float price) {
		carsInStock.add(car);
		priceCatalog.put(car.getChassisNumber(), price);
	}

	/**
	 * List of cars in stock.
	 * 
	 * @return
	 */
	public List<Car> listAllCars() {
		return new ArrayList<Car>(carsInStock);
	}

	/**
	 * Sell the car to client.
	 * 
	 * @param car
	 * @param client
	 * @throws CarNotFoundException
	 * @throws InsufficientFoundsException
	 * @throws IncorrectBankAccountException
	 */
	public void sellCarToClient(Car car, Client client)
			throws CarNotFoundException, InsufficientFoundsException, IncorrectBankAccountException {

		if (!carsInStock.contains(car)) {
			throw new CarNotFoundException("The car - " + car.toString() + " is not found in the dealership!");
		}

		if (carsInStock.contains(car)) {
			// Making transaction and update the bank accounts.
			client.getBankAccount().transferFounds(carDealearshipBankAccount, priceCatalog.get(car.getChassisNumber()));
			// If the client is new, a client account is returned.
			ClientAccount clientAccount = getWithAddClientAccount(client);
			clientAccount.addCarToFleet(car);
			// Delete bought car from stock.
			carsInStock.remove(car);
		}

	}

	/**
	 * Method used to buy car from client.
	 * @param car
	 * @param client
	 * @throws IncorrectBankAccountException
	 * @throws InsufficientFoundsException
	 * @throws CarNotFoundException
	 */
	public void buyCarFromClient(Car car, Client client)
			throws IncorrectBankAccountException, InsufficientFoundsException, CarNotFoundException {
		if (!carsInStock.contains(car)) {
			throw new CarNotFoundException("The car - " + car.toString() + " is not found in the dealership!");
		}
		// update bank account.
		carDealearshipBankAccount.transferFounds(client.getBankAccount(), car.getPrice());
		// after payment add car to DealerShip stock
		carsInStock.add(car);
		// remove sold car from client fleet
		getClientAccount(client).removeCarFromFleet(car);

	}

	/**
	 * Method that search if the client has an account. If not a new one is
	 * created and added to collection with client accounts.
	 * 
	 * @param client
	 * @return clientAccount.
	 */
	private ClientAccount getWithAddClientAccount(Client client) {
		if (!clientAccounts.containsKey(client.getId())) {
			clientAccounts.put(client.getId(), new ClientAccount(client.getName()));
		}
		ClientAccount clientAccount = clientAccounts.get(client.getId());
		return clientAccount;
	}

	/**
	 * New client account entry.
	 * 
	 * @param clientAccount
	 * @param client
	 */
	public void addClientAccount(ClientAccount clientAccount, Client client) {
		clientAccounts.put(client.getId(), clientAccount);
	}

	/**
	 * Get a client account from DealerShip of a certain client.
	 * 
	 * @param client
	 * @return
	 */
	public ClientAccount getClientAccount(Client client) {
		return clientAccounts.get(client.getId());
	}

	// Getters & setters
	public void setCarDealearshipBankAccount(BankAccount carDealearshipBankAccount) {
		this.carDealearshipBankAccount = carDealearshipBankAccount;
	}

	public String getDealershipName() {
		return dealershipName;
	}

	public void setDealershipName(String dealershipName) {
		this.dealershipName = dealershipName;
	}
}
