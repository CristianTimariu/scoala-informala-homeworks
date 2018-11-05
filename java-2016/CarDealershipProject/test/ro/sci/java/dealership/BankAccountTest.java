package ro.sci.java.dealership;

import static org.junit.Assert.*;
import ro.sci.java.dealership.BankAccount;
import ro.sci.java.dealership.exceptions.IncorrectBankAccountException;
import ro.sci.java.dealership.exceptions.InsufficientFoundsException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 *  Some test for BankAccount Class to make sure transactions are making without problems.
 */
public class BankAccountTest {

	BankAccount bankAccount1;
	BankAccount bankAccount2;
	TestBankAccount carDealershipBankAccount;
	CarDealership carDealership;
	Client client1;
	Client client2;
	Client client3;

	@Before
	public void setUp() {
		// given
		carDealershipBankAccount = new TestBankAccount("00D3", 120000);
		carDealership = new CarDealership("compexit");
		bankAccount1 = new BankAccount("12asd3", 11000);
		bankAccount2 = new BankAccount("23fsds3", 25000);
		client1 = new Client("001", "John", null, bankAccount1);
		client2 = new Client("002", "Bob", null, bankAccount2);
	}

	@Test
	public void testIfBankAccountBalanceIsIncrease() {
		// when
		client1.getBankAccount().increaseAmmountOfBankAccount(bankAccount1, 2000);
		carDealershipBankAccount.increaseAmmountOfBankAccount(carDealershipBankAccount, 5000);
		// then
		assertTrue(13000 == client1.getBankAccount().balance);
		assertNotEquals(120000, carDealershipBankAccount.balance);
	}

	@Test
	public void testIfBankAccountBalanceIsDecrease() {
		// when
		client2.getBankAccount().decreaseAmmountFromBankAccount(1000);
		carDealershipBankAccount.decreaseAmmountFromBankAccount(10000);
		// then
		assertEquals(24000, client2.getBankAccount().balance, 0);
		assertTrue(110000 == carDealershipBankAccount.balance);
	}

	@Test
	public void testSuccesfullyTransferFoundsBetweenBankClients()
			throws IncorrectBankAccountException, InsufficientFoundsException {
		// when
		client1.getBankAccount().transferFounds(client2.getBankAccount(), 2000);
		carDealershipBankAccount.transferFounds(bankAccount2, 10000);
		// then
		assertEquals(37000, client2.getBankAccount().balance, 0);
		assertFalse(client1.getBankAccount().balance == 11000);
		assertNotEquals(120000, carDealershipBankAccount.balance);
	}
	
	@Test (expected = NullPointerException.class)
	public void whenBankAccountIsMissing()
			throws InsufficientFoundsException, NullPointerException, IncorrectBankAccountException {
		// given
		client3 = new Client("003", "Jim", null, null); // client3 doesn't have a bankAccount.
		// when
		client2.getBankAccount().transferFounds(client3.getBankAccount(), 1000);
		// then
		fail("Exception should have been thrown");
	}
	
	@After
	public void tearDown() {
		carDealership = null;
		client1 = null;
		client2 = null;
		client3 = null;
	}

	private static class TestBankAccount extends BankAccount {

		public TestBankAccount(String iban, float balance) {
			super(iban, balance);
		}
	}
}
