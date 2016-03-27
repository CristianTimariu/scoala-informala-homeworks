package ro.sci.client;

public class Address {

	public String street;
	public int number;
	public String city;

	public Address(String street, int number, String city) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}

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

	public void getPositiveAddressNumber(int number) {
		if (number < 0) {
			System.err.println("Number must be bigger then 0!!!");
			number = 0;
		}
	}

}
