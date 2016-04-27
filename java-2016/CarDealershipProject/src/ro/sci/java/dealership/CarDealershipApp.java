package ro.sci.java.dealership;

import java.util.List;

import ro.sci.java.dealership.exceptions.CarNotFoundException;
import ro.sci.java.dealership.exceptions.IncorrectBankAccountException;
import ro.sci.java.dealership.exceptions.InsufficientFoundsException;
import ro.sci.java.vehicle.Car;
import ro.sci.java.vehicle.Car.CarComparator;
import ro.sci.java.vehicle.Duster;
import ro.sci.java.vehicle.Logan;
import ro.sci.java.vehicle.VWGolf;
import ro.sci.java.vehicle.VWPassat;

public class CarDealershipApp {

	public static void main(String[] args) {
		/*
		 * Next is a flow I implemented. Or maybe the last "test" :).
		 */
		// Creating 2 customers. One of them is poor.
		Address address1 = new Address("Lalelelor", 22, "Alba Iulia");
		BankAccount c1BankAccount = new BankAccount("00B123Z", 32000);
		Client client1 = new Client("001", "John", address1, c1BankAccount);
		Address address2 = new Address("1Mai", 01, "Turda");
		BankAccount c2BankAccount = new BankAccount("00C123Z", 2000);
		Client client2 = new Client("002", "Bill", address2, c2BankAccount);
		// Creating a carDealerShip.
		CarDealership vwCarDealership = new CarDealership("Volkswagen");
		BankAccount vwCarDealearshipBankAccount = new BankAccount("00A123Z", 1000000);
		vwCarDealership.setCarDealearshipBankAccount(vwCarDealearshipBankAccount);
		Car vwGolf = new VWGolf("21FS342001", 2008, 5000);
		Car vwPassat = new VWPassat("324FE5002", 2010, 11000);
		vwCarDealership.addToStock(vwGolf, vwGolf.getPrice());
		vwCarDealership.addToStock(vwPassat, vwPassat.getPrice());
		// Client1 has a client account for Volkswagen and 2 cars in his fleet.
		ClientAccount client1Account = new ClientAccount(client1.getName());
		vwCarDealership.addClientAccount(client1Account, client1);
		Car duster = new Duster("1001SDF49", 2012, 7000);
		Car vwGolf1 = new VWGolf("213AF423", 2014, 3000);
		client1Account.addCarToFleet(duster);
		client1Account.addCarToFleet(vwGolf1);

		System.out.println("Client 1:" + "\n---------");
		System.out.println(client1.toString());
		System.out.println("Bank Account money: " + client1.getBankAccount().balance);
		System.out.println("\nClient 2:" + "\n---------");
		System.out.println(client2.toString());
		System.out.println("Bank Account money: " + client2.getBankAccount().balance);

		try {
			vwCarDealership.sellCarToClient(vwPassat, client1);
		} catch (CarNotFoundException | InsufficientFoundsException | IncorrectBankAccountException e) {
			e.printStackTrace();
		}
		System.out.println("\nJohn Bank Account after buying a VW Passat: " + client1.getBankAccount().balance);

		// Next, poor client tries to buy a car that he didn't afford.
		try {
			vwCarDealership.sellCarToClient(vwGolf, client2);
		} catch (CarNotFoundException | InsufficientFoundsException | IncorrectBankAccountException e) {
			e.printStackTrace();
		}
		// Client1 tranfer founds to client2.
		try {
			client1.getBankAccount().transferFounds(client2.getBankAccount(), 3500);
		} catch (NullPointerException | InsufficientFoundsException | IncorrectBankAccountException e) {
			e.printStackTrace();
		}
		// Another try for poor client to buy the car.
		try {
			vwCarDealership.sellCarToClient(vwGolf, client2);
		} catch (CarNotFoundException | InsufficientFoundsException | IncorrectBankAccountException e) {
			e.printStackTrace();
		}
		System.out.println("\nBill Bank Account after he gets some help(+3500) and buys a VW Golf: "
				+ client2.getBankAccount().balance);

		try {
			vwCarDealership.buyCarFromClient(duster, client1);
		} catch (IncorrectBankAccountException | InsufficientFoundsException | CarNotFoundException e) {
			e.printStackTrace();
		}

		// here I added another car to fleet to sort 3 elements.
		client1Account.addCarToFleet(duster);
		client1Account.viewFleet();
		List<Car> client1SortedCars = client1Account.getFleet();
		client1SortedCars = client1Account.myFleet(Car.CarComparator.SORT_BY_YEAR);
		System.out.println("\nFleet Sorted By Year");
		for (Car car : client1SortedCars) {
			System.out.println(car.toString());
		}

		/*
		 * Next is the required code for homework.
		 */
		Address address = new Address("street", 01, "Cluj");
		Client c = new Client("001", "Tim", address, null);
		BankAccount bankAccount = new BankAccount("A100029304X293", 30000);
		c.setBankAccount(bankAccount);

		CarDealership compexit = new CarDealership("Compexit");
		BankAccount compexitBankAccount = new BankAccount("BC100243304S23", 1000000);
		compexit.setCarDealearshipBankAccount(compexitBankAccount);
		compexit.addToStock(vwGolf, 7000);
		compexit.addToStock(vwPassat, 11000);
		Car car = vwPassat; // select from stock the car you like
		try {
			compexit.sellCarToClient(car, c);
		} catch (CarNotFoundException | InsufficientFoundsException | IncorrectBankAccountException e1) {
			e1.printStackTrace();
		}
		ClientAccount clientAccount = compexit.getClientAccount(c);
		clientAccount.addCarToFleet(duster); // 2012
		Car logan = new Logan("2213sfdsq312", 2009, 3500);
		clientAccount.addCarToFleet(logan); // 2009

		List<Car> myCars = clientAccount.getFleet();
		myCars = clientAccount.myFleet(CarComparator.SORT_BY_YEAR);
		// Sell oldest car
		Car oldestCar = myCars.get(0);

		try {
			compexit.buyCarFromClient(oldestCar, c);
		} catch (IncorrectBankAccountException | InsufficientFoundsException | CarNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("\nClient from requierment bank account: " + c.getBankAccount().balance);// bank
																									// account
																									// should
																									// be
																									// updated

		clientAccount.viewFleet();// fleet should not contain the sold car.
	}
}
