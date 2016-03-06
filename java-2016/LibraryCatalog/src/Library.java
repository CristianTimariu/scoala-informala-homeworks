import java.util.ArrayList;

public class Library {
	private ArrayList<Book> books;

	public Library() {
		books = new ArrayList<>();
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book book){

		books.add(book);
	}
	
	public boolean deleteBook(Book book){
		return books.remove(book);
	}

}
