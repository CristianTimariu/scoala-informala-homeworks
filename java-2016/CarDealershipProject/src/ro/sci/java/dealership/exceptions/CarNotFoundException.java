package ro.sci.java.dealership.exceptions;

/*
 *  Exception created for CarDealership Class.
 *  Client warning if he's trying to buy a wrong car.
 */

public class CarNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	// That I get from a warning. We use always serials?

	public CarNotFoundException(String message) {
		super(message);
	}
}
