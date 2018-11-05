package ro.sci.java.dealership;

public class Address {

	public String street;
	public int number;
	public String city;

	/**
	 * Constructor for Address
	 * 
	 * @param street
	 * @param number
	 * @param city
	 */
	public Address(String street, int number, String city) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
	}

	// Getters & setters
	public String getCity() {
		return city;
	}

	public int getNumber() {
		return number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Street: " + getStreet() + ", No.: " + getNumber() + ", City: " + getCity();
	}
}
