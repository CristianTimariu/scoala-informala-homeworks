package ro.sci.booking;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCancelBooking {

	List<Accommodation> rooms;

	List<BookingPeriod> periods;

	List<Booking> bookings;

	@Before
	public void setUp() throws Exception {
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

		bookings.add(new Booking(room1, periods.get(0), customer, "12a34", Status.APPROVED));
		bookings.add(new Booking(room1, periods.get(1), customer2, "12b34", Status.APPROVED));
		bookings.add(new Booking(room1, periods.get(2), customer, "12c34", Status.APPROVED));
		bookings.add(new Booking(room1, periods.get(3), customer2, "12d34", Status.APPROVED));

	}

	@After
	public void tearDown() throws Exception {

		bookings = null;
		periods = null;
		rooms = null;

	}

	@Test // Positive Testing.
	public void testCancelBooking() {
		removeBooking("12a34");
		removeBooking("12d34");

		assertNotEquals("12a34", bookings.get(0).getId());
		assertTrue("12b34".equals(bookings.get(0).getId()));
	}

	@Test // Negative Testing.
	public void testRemoveInexistingBooking() {
		// Remove incorrect booking and test if size modifies.
		removeBooking("12fg34");

		assertEquals(4, bookings.size());
	}

	private void removeBooking(String id) {
		// Find & remove booking to "cancel" it.
		Iterator<Booking> iter = bookings.iterator();
		while (iter.hasNext()) {
			Booking booking = iter.next();
			if (id.equals(booking.getId())) {
				iter.remove();
			}
		}
	}

	private Date getDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);

		return c.getTime();
	}
}
