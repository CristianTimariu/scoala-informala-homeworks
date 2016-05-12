package ro.sci.booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingPeriod {

	public List<BookingPeriod> periods = new ArrayList<BookingPeriod>();

	private Date from;
	private Date to;

	public BookingPeriod(Date from, Date to) {
		this.from = from;

		this.to = to;
	}

	public BookingPeriod() {
	}

	public Date getFrom() {
		return from;
	}

	public Date getTo() {
		return to;
	}
}
