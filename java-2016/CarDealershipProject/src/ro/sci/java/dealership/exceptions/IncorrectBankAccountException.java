package ro.sci.java.dealership.exceptions;

/*
 *  Exception created for BankAccount Class.
 *  When the bank account does not exist or is invalid.
 */

public class IncorrectBankAccountException extends Exception {

	private static final long serialVersionUID = 1L;

	public IncorrectBankAccountException(String message) {
		super(message);
	}
}
