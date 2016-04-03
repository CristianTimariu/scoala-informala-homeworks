package ro.sci.shop;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

	List<Book> books = new ArrayList<Book>();

	public void addBook(Book book) {

		books.add(book);

	}

	public void printBooks() {
		System.out.println("Books In Catalog!");
		for (Book b : books) {
			System.out.println("------------------");
			System.out.println("Title: " + b.getTitle());
			System.out.println("Title: " + b.getAuthor());
			System.out.println("Title: " + b.getGenre());
		}
		System.out.println("------------------");
		System.out.println(" END OF CATALOG\n");
	}

	public int searchBook(String title) {

		for (Book b : books) {
			if (b.getTitle().equals(title)) {
				System.out.println("Your book is in catalog!");
				return 0;
			}
		}
		throw new IllegalArgumentException("We don't have the book named " + title + " in Catalog! Nice try!");
	}

	public long searchBookIsbn(String title) { 
		long isbn = 0;
		for (Book b : books) {
			// b.getTitle().equals(title)
			if (b.getTitle() == title) {
				isbn = b.getIsbn();
			} else {
				System.err.println("We don't have your book!!!");
			}
		}
		return isbn;
	}

	public Book getBookByIsbn(long isbn) {
		for (Book b : books) {
			if (isbn == b.getIsbn())
				return b;
		}
		return new Book();
	}

}