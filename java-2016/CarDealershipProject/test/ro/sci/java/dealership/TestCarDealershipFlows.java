package ro.sci.java.dealership;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.sci.java.dealership.exceptions.CarNotFoundException;
import ro.sci.java.dealership.exceptions.IncorrectBankAccountException;
import ro.sci.java.dealership.exceptions.InsufficientFoundsException;
import ro.sci.java.vehicle.Car;
import ro.sci.java.vehicle.Duster;
import ro.sci.java.vehicle.Logan;
import ro.sci.java.vehicle.VWGolf;
import ro.sci.java.vehicle.VWPassat;

public class TestCarDealershipFlows {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSuccesfullSellingOfCarToClientFlow()
			throws CarNotFoundException, InsufficientFoundsException, IncorrectBankAccountException {
		// given
		CarDealership carDealership = new CarDealership("compexit");

		Address address = new Address("street", 22, "city");
		BankAccount bA = new TestBankAccount("000", 50000);
		Client client = new Client("asdf12", "Jack", address, null);
		client.setBankAccount(bA);
		Car logan = new Logan("aaaaa", 2015, 4500);
		Car vwGolf = new VWGolf("bbbbb", 2014, 8500);
		carDealership.addToStock(logan, 4500);
		carDealership.addToStock(vwGolf, 8500);
		TestBankAccount carDealershipBankAccount = new TestBankAccount("001", 60000);
		carDealership.setCarDealearshipBankAccount(carDealershipBankAccount);
		ClientAccount clientAccount = new ClientAccount(client.getId());
		carDealership.addClientAccount(clientAccount, client);
		// when
		carDealership.sellCarToClient(logan, client);
		// then
		assertEquals(1, carDealership.listAllCars().size());
		assertFalse(carDealership.listAllCars().contains(logan));
		assertEquals(45500, (((TestBankAccount) client.getBankAccount()).getBalance()), 0);
		assertEquals(64500, carDealershipBankAccount.getBalance(), 0);
		assertNotNull(clientAccount);
		assertTrue(clientAccount.getFleet().contains(logan));
	}

	@Test
	public void testSuccesfullBuyingOfCarFromClientFlow()
			throws IncorrectBankAccountException, InsufficientFoundsException, CarNotFoundException {
		// given
		CarDealership carDealership = new CarDealership("compexit");
		Address address = new Address("street", 22, "city");
		BankAccount bA = new TestBankAccount("000", 50000);
		Client client = new Client("asdf12", "Jack", address, bA);
		TestBankAccount carDealershipBankAccount = new TestBankAccount("001", 60000);
		carDealership.setCarDealearshipBankAccount(carDealershipBankAccount);
		Car logan = new Logan("aaaaa", 2015, 4500);
		Car vwGolf = new VWGolf("bbbbb", 2014, 8500);
		Car duster = new Duster("ccccc", 2013, 7000);
		Car vwPassat = new VWPassat("ddddd", 2011, 6000);
		carDealership.addToStock(logan, 4500);
		carDealership.addToStock(vwGolf, 8500);
		ClientAccount clientAccount = new ClientAccount(client.getName());
		clientAccount.addCarToFleet(vwPassat);
		clientAccount.addCarToFleet(duster);
		carDealership.addClientAccount(clientAccount, client);
		// when
		carDealership.buyCarFromClient(duster, client);
		// then
		assertEquals(1, clientAccount.getFleet().size());
		assertTrue(carDealership.listAllCars().contains(duster));
		assertEquals(57000, (((TestBankAccount) client.getBankAccount()).getBalance()), 0);
		assertEquals(53000, carDealershipBankAccount.getBalance(), 0);
	}

	@Test(expected = InsufficientFoundsException.class)
	public void whenNotEnoughMoneyCarSellingFails()
			throws InsufficientFoundsException, CarNotFoundException, IncorrectBankAccountException {
		// given
		CarDealership carDealership = new CarDealership("compexit");
		Address address = new Address("street", 22, "city");
		BankAccount bA = new TestBankAccount("000", 500);
		Client client = new Client("asdf12", "Jack", address, null);
		client.setBankAccount(bA);
		Car logan = new Logan("aaaaa", 2015, 4500);
		Car vwGolf = new VWGolf("bbbbb", 2014, 8500);
		carDealership.addToStock(logan, 4500);
		carDealership.addToStock(vwGolf, 8500);
		// when
		TestBankAccount carDealershipBankAccount = new TestBankAccount("001", 50000);
		carDealership.setCarDealearshipBankAccount(carDealershipBankAccount);
		carDealership.sellCarToClient(logan, client);
		// then
		fail("Exception should have been thrown");
	}

	@Test(expected = CarNotFoundException.class)
	public void whenTryToBuyACarThatIsNotInTheDealershipFails()
			throws InsufficientFoundsException, CarNotFoundException, IncorrectBankAccountException {
		// given
		CarDealership carDealership = new CarDealership("compexit");
		Address address = new Address("street", 22, "city");
		BankAccount bA = new TestBankAccount("000", 500);
		Client client = new Client("asdf12", "Jack", address, null);
		client.setBankAccount(bA);
		Car logan = new Logan("aaaaa", 2015, 4500);
		Car vwGolf = new VWGolf("bbbbb", 2014, 8500);
		Car passat = new VWPassat("qw123e", 2012, 7000); // car that is not
															// added in the
															// stock
		carDealership.addToStock(logan, 4500);
		carDealership.addToStock(vwGolf, 8500);
		// when
		carDealership.sellCarToClient(passat, client); // trying to sell the car
														// that is not in the
														// stock;
		// then
		fail("Exception should have been thrown");
	}

	private static class TestBankAccount extends BankAccount {

		public TestBankAccount(String iban, float balance) {
			super(iban, balance);
		}

		private float getBalance() {
			return balance;
		}
	}

}
