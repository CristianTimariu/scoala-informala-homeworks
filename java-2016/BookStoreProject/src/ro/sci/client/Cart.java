package ro.sci.client;

import java.util.ArrayList;
import java.util.List;

import ro.sci.shop.Book;

public class Cart {

	private List<Book> books = new ArrayList<Book>(); 

	public Cart(List<Book> cart) {
		super();
		this.books = cart;

	}

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBook(List<Book> book) {
		this.books = book;
	}

	public void addBookToCart(Book b) {
		books.add(b);
	}

}
