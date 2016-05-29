package ro.sci.booking.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.sci.booking.*;

public class DBTest {

	private Connection connection;

	@Before
	public void setUp() {
		connection = DBConnection.getInstance();
	}

	@After
	public void tearDown() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Test insert to booking Database.
	 */
	@Test
	public void testInsert() {
		String statement = "INSERT INTO \"Accommodation\"(type, bed_type, max_guests, description) values(?,?,?,?)";
		String statement2 = "INSERT INTO \"room_fair\"(value,season) values(?,?)";
		String statement3 = "INSERT INTO \"accommodation_fair_relation\"(id_accommodation, id_room_fair) values(?,?)";
		// creating an accommodation which is used to test the insert.
		Accommodation room1 = new Accommodation(AccommodationType.SINGLE, "Camera cu vedere la mare", 1,
				BedType.QUEEN_SIZE);

		PreparedStatement ps;
		String generatedCols[] = { "id" };
		try {
			// Insert the object room1 to Accommodation table in database.
			ps = connection.prepareStatement(statement, generatedCols);
			ps.setObject(1, room1.getType().name());
			ps.setObject(2, room1.getBedType().name());
			ps.setObject(3, room1.getMaxGuests());
			ps.setObject(4, room1.getDescription());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			Long idAccommodation = null;
			if (rs.next()) {
				idAccommodation = rs.getLong(1);
			}
			// Insert to room_fair table the value and season into database
			ps = connection.prepareStatement(statement2, generatedCols);
			ps.setObject(1, 110);
			ps.setObject(2, "HIGH");

			ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			Long idRoomFair = null;
			if (rs.next()) {
				idRoomFair = rs.getLong(1);
			}
			// FN3 relation.
			ps = connection.prepareStatement(statement3, generatedCols);
			ps.setObject(1, idAccommodation);
			ps.setObject(2, idRoomFair);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Test select from DB. I choose to print from accommodation the id and the
	 * value from room_fair table. Like when you go to the hotel and you have
	 * "room no. 21, 120 RON/Night"
	 */
	@Test
	public void testSelect() {
		String statement = "SELECT ac.id, room.value from \"accommodation_fair_relation\" relation inner join \"Accommodation\" ac on relation.id_accommodation = ac.id inner join \"room_fair\" room on relation.id_room_fair = room.id";

		try {
			PreparedStatement ps = connection.prepareStatement(statement);
			ResultSet rs = ps.executeQuery();

			boolean hasResult = rs.next();
			if (hasResult) {
				System.out.println("ID room \t Price/Night");
				while (rs.next()) {
					System.out.println(rs.getLong("id") + "\t\t" + rs.getDouble("value"));
				}
			} else {
				System.out.println("No results");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}