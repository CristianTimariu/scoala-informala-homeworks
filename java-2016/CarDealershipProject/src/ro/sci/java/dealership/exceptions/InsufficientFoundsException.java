package ro.sci.java.dealership.exceptions;

/*
 *  Exception created for BankAccount Class.
 *  There are not enough money in the bank account.
 */

public class InsufficientFoundsException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientFoundsException(String message) {
		super(message);
	}
}
