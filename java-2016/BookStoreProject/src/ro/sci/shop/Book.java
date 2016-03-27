package ro.sci.shop;

public class Book {

	private String title;
	private String author;
	private String genre;
	private long isbn;
	private Stock stock;

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Book(String title, String author, String genre, long isbn, Stock stock) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.isbn = isbn;
		this.stock = stock;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
}
