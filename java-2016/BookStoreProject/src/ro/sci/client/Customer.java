package ro.sci.client;

import ro.sci.shop.*;
import ro.sci.shop.Catalog;

public class Customer {

	private String name;
	public Address address;
	private String email;
	protected Cart cart;

	public Customer() {
	}

	public Customer(String name, String email, Address address, Cart cart) {
		super();
		this.name = name;
		this.email = email;
		this.cart = cart;
		this.address = address;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return this.address;
	}

	// Methods for customer's address.
	public Address addAddress(String street, int number, String city) {
		Address address1 = new Address(street, number, city);
		address1.setNumber(number);
		address1.setStreet(street);
		address1.setCity(city);

		return address;
	}

	public void printAddress(Customer customer) {
		System.out.println("Customer named " + customer.getName() + " - address: " + address.getStreet() + ", "
				+ address.getNumber() + ", " + address.getCity());
	}

	/*
	 * Add a book to cart!
	 * 
	 * -when you add a book (chosen by title) first we search the isbn; 
	 * -then you get your type of book; 
	 * -add book to customers cart; 
	 * -the we make an update to the stock of the wanted book;
	 */

	public void addToCart(String title, int noOfBooks) {
		Catalog c = new Catalog();
		long isbn = c.searchBookIsbn(title);
		Book b = c.getBookByIsbn(isbn);
		this.cart.addBookToCart(b);

		System.out.println("Book " + title + " succesfully added to your cart!");

		Stock s = new Stock();

		s.updateStock(isbn, noOfBooks);
	}

}
