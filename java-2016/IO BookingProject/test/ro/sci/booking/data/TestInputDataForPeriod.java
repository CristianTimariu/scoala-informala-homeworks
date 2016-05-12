package ro.sci.booking.data;

import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ro.sci.booking.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the booking period reader from DataLoader.Class
 */
public class TestInputDataForPeriod {

	/** String which holds the path to booking periods. */
	private String PERIODS_FILE_PATH = "D:/Courses/JAVA/workspace/BookingProject/files/booking_calendar.txt";
	/**
	 * String which holds the path to booking periods with wrong no. of fields.
	 */
	private String WRONG_PERIOD_FILE_PATH = "D:/Courses/JAVA/workspace/BookingProject/files/wrong_fields_number_periods.txt";

	List<BookingPeriod> periods;

	@Before
	public void setUp() throws Exception {
		periods = new ArrayList<>();

		DataLoader dataLoader = new DataLoader();
		dataLoader.readBookingPeriodsFile(Paths.get(PERIODS_FILE_PATH)); // reading
		periods.addAll(dataLoader.getPeriods()); // add all readed periods to
													// array.
	}

	@After
	public void tearDown() throws Exception {
		periods = null;
	}

	@Test
	public void whenReadingFromFileValidate() {
		Date from = getDate(2016, 5, 1);
		Date to = getDate(2016, 5, 10);
		assertTrue(periods.get(0).getFrom().equals(from));
		assertEquals(to, periods.get(0).getTo());
	}

	@Test(expected = InvalidNumberOfFieldsException.class)
	public void readedPeriodsFromFileDoesNotHaveRequieredNumberOfFields() throws InvalidNumberOfFieldsException {
		DataLoader dataLoader = new DataLoader();
		dataLoader.readBookingPeriodsFile((Paths.get(WRONG_PERIOD_FILE_PATH)));
		fail("Exception should have been thrown");
	}

	public Date getDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
}
