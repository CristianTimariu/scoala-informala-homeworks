package ro.sci.shop;

import java.util.ArrayList;
import java.util.List;

import ro.sci.client.Address;
import ro.sci.client.Cart;
import ro.sci.client.Customer;

public class BookStoreApp {

	public static void main(String[] args) {

		// Creating some books.
		Stock s1 = new Stock(30, 120213342);
		Book b1 = new Book("AAA", "aaa", "Adventure", 120213342, s1);
		Stock s2 = new Stock(25, 120212345);
		Book b2 = new Book("BBB", "bbb", "Adventure", 120212345, s2);
		Stock s3 = new Stock(15, 120213123);
		Book b3 = new Book("CCC", "ccc", "Adventure", 120213123, s3);
		Stock s4 = new Stock(30, 120276543);
		Book b4 = new Book("DDD", "ddd", "Adventure", 120276543, s4);

		// Creating the catalog and stock
		Catalog catalog = new Catalog();
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(s1);
		stockList.add(s2);
		stockList.add(s3);
		stockList.add(s4);

		catalog.addBook(b1);
		catalog.addBook(b2);
		catalog.addBook(b3);
		catalog.addBook(b4);

		catalog.printBooks(); // Using Print method.

		// Creating a customer. First set an address and his own cart!
		Address address = new Address("Brazilor", 22, "Aiud");
		Cart cart1 = new Cart();

		Customer customer = new Customer("Chris", "cristian.timariu@gmail.com", address, cart1);
		customer.printAddress(customer);

		// Searching for a book
		/*
		 * catalog.searchBook("ZZZZZ"); <-- Test error with "book not found";
		 */
		catalog.searchBook("CCC");

		// Add to cart
		customer.addToCart("CCC", 3);

		// customer.getPayment(pay = true); <-- clear cart and exit store.

	}

}
