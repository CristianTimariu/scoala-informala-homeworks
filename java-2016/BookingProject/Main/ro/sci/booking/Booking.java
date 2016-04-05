package ro.sci.booking;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Booking {

	public List<Booking> bookings = new ArrayList<Booking>();
	private Accommodation room;
	private BookingPeriod bookingPeriod;
	private Customer customer;
	private String id;
	private Status status;

	public Booking(Accommodation room, BookingPeriod bookingPeriod, Customer customer, String id, Status status) {
		super();
		this.room = room;
		this.bookingPeriod = bookingPeriod;
		this.customer = customer;
		this.id = id;
		this.status = status;
	}

	public Booking(Accommodation room, BookingPeriod bookingPeriod) {
		this.room = room;
		this.bookingPeriod = bookingPeriod;
	}

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Accommodation getRoom() {
		return room;
	}

	public void setRoom(Accommodation room) {
		this.room = room;
	}

	public BookingPeriod getBookingPeriod() {
		return bookingPeriod;
	}

	public void setBookingPeriod(BookingPeriod bookingPeriod) {
		this.bookingPeriod = bookingPeriod;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Status isStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void viewBooking(String id) {
		for (Booking booking : bookings) {
			if (booking.getId().equals(id)) {
				System.out.println("Customer Firsts Name: " + booking.getCustomer().getfName() + "\n 		Last Name: "
						+ booking.getCustomer().getlName() + "\nAccommodation: " + booking.getRoom().getType()
						+ "\nPeriod: " + booking.getBookingPeriod().getFrom() + " - "
						+ booking.getBookingPeriod().getTo() + "\nPrice / night: "
						+ booking.getRoom().getFair().getValue());
			}
		}
		throw new IllegalArgumentException("We don't have your booking! Please insert the right ID!");
	}

	public Date getDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);

		return c.getTime();
	}

}
