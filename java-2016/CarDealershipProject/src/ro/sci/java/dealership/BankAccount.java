package ro.sci.java.dealership;

import ro.sci.java.dealership.exceptions.IncorrectBankAccountException;
import ro.sci.java.dealership.exceptions.InsufficientFoundsException;

/**
 * 
 * @author Timy
 *
 */
public class BankAccount {

	protected float balance;
	private String iban;

	/**
	 * Constructor for BankAccount
	 * 
	 * @param iban
	 * @param balance
	 */
	public BankAccount(String iban, float balance) {
		super();
		this.iban = iban;
		this.balance = balance;

	}

	// Getters & setters
	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * Method used to update balance in bank account when a car is sell or
	 * bought by car DealerShip.
	 * 
	 * @param destinationAccount
	 * @param amount
	 * @throws IncorrectBankAccountException
	 * @throws InsufficientFoundsException
	 */
	public void transferFounds(BankAccount destinationAccount, float amount)
			throws IncorrectBankAccountException, InsufficientFoundsException {

		if (destinationAccount.equals(null)) {
			throw new NullPointerException("Bank Account not found!");
		}
		if (balance < amount) {
			throw new InsufficientFoundsException("Insufficient founds!");
		}
		// Removing money from client account
		decreaseAmmountFromBankAccount(amount);
		// Update money for DealerShip
		increaseAmmountOfBankAccount(destinationAccount, amount);
	}

	public void increaseAmmountOfBankAccount(BankAccount destinationAccount, float amount) {
		destinationAccount.balance += amount;
	}

	public void decreaseAmmountFromBankAccount(float amount) {
		balance -= amount;
	}
}
