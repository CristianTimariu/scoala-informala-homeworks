import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.sci.shop.Book;
import ro.sci.shop.Stock;

public class TestCatalog {

	List<Book> catalog = null;

	Stock s1 = new Stock(11, 1001342534);
	Book b1 = new Book("Ionea", "Liviu", "drama", 1001342534, s1);

	@Before
	public void initCatalog() {
		catalog = new ArrayList<Book>();
		catalog.add(b1);
	}

	@After
	public void destroyCatalog() {
		catalog = null;
	}

	@Test
	public void testCatalogSize() {
		assertNotNull(catalog);
		assertTrue(catalog.size() > 0);
	}

	@Test
	public void testCatalogContent() {
		Book firstBook = catalog.get(0);
		assertEquals("Ionea", firstBook.getTitle());
		assertEquals("drama", firstBook.getGenre());
	}

}
