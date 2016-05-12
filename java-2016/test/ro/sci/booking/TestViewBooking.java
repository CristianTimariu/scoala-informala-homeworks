package ro.sci.booking;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Timy
 *
 */

/*
 * Here I run negative and positive test to make sure that my application print
 * correctly my booking.
 * 
 * I choose in my application to view booking by id (or it can be by name)
 */

public class TestViewBooking {

	List<Accommodation> rooms;

	List<BookingPeriod> periods;

	List<Booking> bookings;

	@Before
	public void init() {
		rooms = new ArrayList<Accommodation>();

		Date from = getDate(2016, 5, 1);
		Date to = getDate(2016, 8, 27);
		Season season = new Season();
		season.createSeason(SeasonType.HIGH, from, to);

		RoomFare roomFair1 = new RoomFare();
		roomFair1.createRoomFare(100, season);
		Accommodation room1 = new Accommodation();
		room1.createNewRoom(AccommodationType.ROYAL, roomFair1);
		rooms.add(room1);

		periods = new ArrayList<BookingPeriod>();

		periods.add(new BookingPeriod(getDate(2016, 5, 12), getDate(2016, 5, 17)));
		periods.add(new BookingPeriod(getDate(2016, 6, 10), getDate(2016, 6, 13)));
		periods.add(new BookingPeriod(getDate(2016, 7, 15), getDate(2016, 7, 20)));
		periods.add(new BookingPeriod(getDate(2016, 8, 2), getDate(2016, 8, 4)));

		bookings = new ArrayList<Booking>();

		Customer customer = new Customer("Tucker", "John", "email@yahoo.com", 0755225454);
		Customer customer2 = new Customer(null, null, "@fsdf", 075501471);

		bookings.add(new Booking(room1, periods.get(0), customer, "1a23b", Status.APPROVED));
		bookings.add(new Booking(room1, periods.get(1), customer2, "012", Status.APPROVED));
		bookings.add(new Booking(room1, periods.get(2)));
	}

	@After
	public void destroy() {
		bookings = null;
		periods = null;
		rooms = null;
	}

	@Test // Negative Testing (test if name is introduced.)
	public void testIfTheNameIsNull() {

		assertNull(findBookingByID("012").getCustomer().getfName());
	}

	@Test // Positive Testing
	public void testViewBooking() {

		assertTrue("John".equals(findBookingByID("1a23b").getCustomer().getlName()));

	}

	public Booking findBookingByID(String id) {
		// I create this method to "find" booking in order to verify my fields
		// from specific booking.
		// In Class Booking I create method viewBooking.
		for (Booking booking : bookings) {
			if (booking.getId().equals(id)) {
				return booking;
			}
		}
		throw new IllegalArgumentException("We don't have your booking!");
	}

	public Date getDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);

		return c.getTime();
	}
}
