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
 * Test the accommodation reader from DataLoader.Class
 */
public class TestInputDataForRoom {

	/** String which holds the path to room type (accommodation). */
	private String ROOMS_FILE_PATH = "D:/Courses/JAVA/workspace/BookingProject/files/rooms.txt";
	/**
	 * String which holds the path to a wrong initialisation for a room type.
	 */
	private String WRONG_ROOM_FILE_PATH = "D:/Courses/JAVA/workspace/BookingProject/files/wrong_type_room.txt";

	List<Accommodation> rooms;

	@Before
	public void setUp() throws Exception {
		rooms = new ArrayList<Accommodation>();

		DataLoader dataLoader = new DataLoader();
		dataLoader.readRoomsFile(Paths.get(ROOMS_FILE_PATH)); // reading
		rooms.addAll(dataLoader.getRooms()); // add all readed rooms.
	}

	@After
	public void tearDown() {
		rooms = null;
	}

	@Test
	public void whenReadingFromFileValidate() {
		assertTrue(rooms.get(0).getRoomID().equals("room1"));
		assertTrue(rooms.get(0).getFare().getValue() == 100);
		assertTrue(rooms.get(0).getType().equals(AccommodationType.SINGLE));

		RoomFare roomFare = new RoomFare();
		roomFare.setValue(150);
		Accommodation room2 = new Accommodation("room2", AccommodationType.DOUBLE, "\"camera cu vedere la munte\"", 2,
				BedType.KING_SIZE, roomFare);
		assertSame(rooms.get(1).getBedType(), room2.getBedType());
		assertEquals(rooms.get(1).getFare().getValue(), room2.getFare().getValue(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenReadingAccommodationTypeFails() throws InvalidNumberOfFieldsException {
		DataLoader dataLoader = new DataLoader();
		dataLoader.readRoomsFile(Paths.get(WRONG_ROOM_FILE_PATH));
		fail("Exception should have been thrown");
	}

	@Test(expected = NumberFormatException.class)
	public void whenTryToReadInteggerFails() throws InvalidNumberOfFieldsException {
		DataLoader dataLoader = new DataLoader();
		dataLoader.readRoomsFile(Paths.get("D:/Courses/JAVA/workspace/BookingProject/files/wrong_format_room.txt"));
		fail("Exception should have been thrown");
	}

	@Test(expected = InvalidNumberOfFieldsException.class)
	public void readedAccommodationFromFileDoesNotHaveRequieredNumberOfFields() throws InvalidNumberOfFieldsException {
		DataLoader dataLoader = new DataLoader();
		dataLoader.readRoomsFile(
				Paths.get("D:/Courses/JAVA/workspace/BookingProject/files/wrong_fields_number_room.txt"));
		fail("Exception should have been thrown");
	}
}
