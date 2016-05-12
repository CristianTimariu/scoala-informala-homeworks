package ro.sci.booking.data;

import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.sci.booking.*;

/**
 * Test the writer from DataLoader.class
 */
public class TestOutputData {

	private String CREATED_ROOM_PATH = "D:/Courses/JAVA/Workspace/BookingProject/files/created_rooms.txt"; // output

	List<Accommodation> rooms;
	List<BookingPeriod> periods;
	List<Booking> bookings;

	@Before
	public void setUp() throws Exception {
		rooms = new ArrayList<Accommodation>();
		periods = new ArrayList<BookingPeriod>();
		bookings = new ArrayList<Booking>();
		// creating & adding rooms to array.
		RoomFare roomFare = new RoomFare(360);
		Accommodation room = new Accommodation("401", AccommodationType.ROYAL, "Cu vedere la mare", 4,
				BedType.KING_SIZE, roomFare);
		roomFare.setValue(340);
		// write accommodation to file "created_rooms".
		DataLoader dataLoader = new DataLoader();
		String textToWrite = room.toString();
		dataLoader.writeFile(Paths.get(CREATED_ROOM_PATH), textToWrite);
	}

	@After
	public void tearDown() throws Exception {
		rooms = null;
		periods = null;
		bookings = null;
	}

	@Test
	public void testAccommodationOutputWithFileReader() throws InvalidNumberOfFieldsException {
		// Reading the new file.
		DataLoader dataLoader = new DataLoader();
		dataLoader.readRoomsFile(Paths.get(CREATED_ROOM_PATH));
		// Adding the accommodations to rooms list.
		rooms.addAll(dataLoader.getRooms());

		assertTrue(rooms.get(0).getType().equals(AccommodationType.ROYAL));
		assertEquals(340, rooms.get(0).getFare().getValue(), 0);
	}
}
