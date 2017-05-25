package ro.sci.booking.data;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import ro.sci.booking.*;

/**
 * A tool for reading/writing a file.
 */
public class DataLoader implements BookingIO {

	private Collection<Accommodation> rooms = new ArrayList<Accommodation>();
	private Collection<BookingPeriod> periods = new ArrayList<BookingPeriod>();

	// return ArrayList of rooms and periods.
	public Collection<Accommodation> getRooms() {
		return new ArrayList<Accommodation>(rooms);
	}

	public Collection<BookingPeriod> getPeriods() {
		return new ArrayList<BookingPeriod>(periods);
	}

	/**
	 * Input method. Reads a line from a file and creates the room accommodation
	 * object.
	 * 
	 * @param file
	 * @throws InvalidNumberOfFieldsException
	 */
	public void readRoomsFile(Path file) throws InvalidNumberOfFieldsException {
		Charset charset = Charset.forName(IO_CHARSET);
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				rooms.add(createReadedAccommodation(line));
			}
		} catch (IOException x) {
			System.err.println("IOException: " + x);
		}
	}

	/**
	 * Method used to create accommodation(room) with a line that was readed
	 * from a file.
	 * 
	 * @param line
	 * @return Accommodation
	 * @throws InvalidNumberOfFieldsException
	 */
	private Accommodation createReadedAccommodation(String line) throws InvalidNumberOfFieldsException {
		Accommodation accommodation = new Accommodation();
		RoomFare roomFare = new RoomFare();

		String[] values = line.split(COMMA);
		if (values.length != 6) {
			throw new InvalidNumberOfFieldsException("You must complete ALL six accommodation fields!"
					+ "\nRoomID, Accommodation Type, Description, Max Guests, Bed Type, Fare.");
		}
		/*
		 * - room1, SINGLE, "camera cu vedere la munte", 2, KING_SIZE, 100 -
		 * Line example.
		 */
		accommodation.setRoomID(values[0].trim());
		accommodation.setType(AccommodationType.valueOf(values[1]));
		accommodation.setDescription(values[2]);
		accommodation.setMaxGuests(Integer.parseInt(values[3]));
		accommodation.setBedType(BedType.valueOf(values[4]));
		roomFare.setValue(Double.parseDouble(values[5]));
		accommodation.setFare(roomFare);
		return accommodation;
	}

	/**
	 * Input method. Reads a line from a file and creates the BookingPeriod
	 * object.
	 * 
	 * @param file
	 * @throws InvalidNumberOfFieldsException
	 */
	public void readBookingPeriodsFile(Path file) throws InvalidNumberOfFieldsException {
		Charset charset = Charset.forName(IO_CHARSET);
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				periods.add(createBookingPeriod(line));
			}
		} catch (IOException x) {
			System.err.println("IOException: " + x);
		}
	}

	/**
	 * Method used to create a booking period(from, to) with a line that is
	 * readed from a file.
	 * 
	 * @param line
	 * @return BookingPeriod
	 * @throws InvalidNumberOfFieldsException
	 */
	private BookingPeriod createBookingPeriod(String line) throws InvalidNumberOfFieldsException {
		Date from = null, to = null;
		String[] values = line.split(COMMA);
		if (values.length != 3) {
			throw new InvalidNumberOfFieldsException(
					"You must complete ALL THREE booking period fields!" + "\nRoomID, Period from, Period to.");
		}
		try {
			java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
			from = simpleDateFormat.parse(values[1]);
			to = simpleDateFormat.parse(values[2]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new BookingPeriod(from, to);
	}

	/**
	 * Output. Method used to write in external file.
	 * 
	 * @param file
	 * @param textToWrite
	 *            (String to be written)
	 */
	public void writeFile(Path file, String textToWrite) {
		Charset charset = Charset.forName(IO_CHARSET);
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset, CREATE, APPEND);
				FileWriter fileWriter = new FileWriter(new File(file.toString()))) {

			fileWriter.write(textToWrite);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}