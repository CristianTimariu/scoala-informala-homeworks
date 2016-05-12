package ro.sci.booking.data;

import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.sci.booking.Accommodation;
import ro.sci.booking.Booking;
import ro.sci.booking.BookingPeriod;
import ro.sci.booking.Customer;
import ro.sci.booking.Status;

public class TestBookingFlowFromInputData {

	/** String which holds the path to room type (accommodation). */
	private String ROOMS_FILE_PATH = "D:/Courses/JAVA/workspace/BookingProject/files/rooms.txt";
	/** String which holds the path to booking periods. */
	private String PERIODS_FILE_PATH = "D:/Courses/JAVA/workspace/BookingProject/files/bookingPeriod_test.txt";

	List<Accommodation> rooms;
	List<BookingPeriod> periods;
	List<Booking> bookings;

	@Before
	public void setUp() throws Exception {
		rooms = new ArrayList<Accommodation>();
		periods = new ArrayList<BookingPeriod>();
		bookings = new ArrayList<Booking>();

		DataLoader dataLoader = new DataLoader();
		dataLoader.readRoomsFile(Paths.get(ROOMS_FILE_PATH)); // reading rooms
		rooms.addAll(dataLoader.getRooms()); // add all readed rooms.
		dataLoader.readBookingPeriodsFile(Paths.get(PERIODS_FILE_PATH)); // reading
																			// periods
		periods.addAll(dataLoader.getPeriods()); // add all readed periods to
													// array.
		Customer customer = new Customer("Timariu", "Cristian", "email@fsdf", 075501471);
		// First booking is made by first line from rooms and periods readed
		// files.
		bookings.add(new Booking(rooms.get(0), periods.get(0), customer, "001", Status.APPROVED));
		// Creating new bookings to be tested.
		Booking booking = new Booking(rooms.get(0), periods.get(1), new Customer(), "002", Status.PENDING);
		Booking booking1 = new Booking(rooms.get(1), periods.get(2), new Customer(), "003", Status.PENDING);
		Booking booking2 = new Booking(rooms.get(1), periods.get(3), new Customer(), "004", Status.PENDING);
		checkIfBookingIsAvailable(booking);
		checkIfBookingIsAvailable(booking1);
		checkIfBookingIsAvailable(booking2);
	}

	@After
	public void tearDown() throws Exception {
		rooms = null;
		periods = null;
		bookings = null;
	}

	/**
	 * First booking that is checked is occupyed in that period. The status
	 * should change to rejected.
	 */
	@Test
	public void whenReadedBookigIsRejected() {
		assertEquals(Status.REJECTED, bookings.get(1).isStatus());
	}

	@Test
	public void whenReadedBookingIsApproved() {
		assertTrue(bookings.get(2).isStatus().equals(Status.APPROVED));
	}

	/**
	 * Verify a new booking if is not in the same period with other bookings.
	 * Adds the booking to list and change the status to APPROVED, if the period
	 * is clear, if not to REJECTED.
	 * 
	 * @param newBooking
	 */
	private void checkIfBookingIsAvailable(Booking newBooking) {
		// We analyze a new booking if is not in the same period with other
		// bookings.
		boolean available = false;
		for (Booking booking : bookings) {
			if (newBooking.getBookingPeriod().getFrom().before(booking.getBookingPeriod().getFrom())
					&& newBooking.getBookingPeriod().getTo().before(booking.getBookingPeriod().getFrom())
					|| newBooking.getBookingPeriod().getFrom().after(booking.getBookingPeriod().getTo())
							&& newBooking.getBookingPeriod().getTo().before(booking.getBookingPeriod().getTo())) {
				available = true;
				newBooking.setStatus(Status.APPROVED);
				break;
			}
		}
		if (available == false) {
			newBooking.setStatus(Status.REJECTED);
		}
		bookings.add(newBooking);
	}
}
