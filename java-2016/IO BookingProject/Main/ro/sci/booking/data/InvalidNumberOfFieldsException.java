package ro.sci.booking.data;

/**
 * Exception created for Booking project.
 * It's a warning that you have to complete a certain number of fields.
 */
public class InvalidNumberOfFieldsException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidNumberOfFieldsException(String message) {
		super(message);
	}
}
