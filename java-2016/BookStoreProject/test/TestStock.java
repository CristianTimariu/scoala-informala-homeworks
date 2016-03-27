import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import ro.sci.shop.Stock;

/**
 * Run some test to check if Stock class methods works properly
 */

/**
 * @author Timy
 *
 */
public class TestStock {

	List<Stock> stockList = null;

	private long isbn = 1001459630;

	Stock s1 = new Stock(11, isbn);
	Stock s2 = new Stock(15, 1001342534);

	@Before
	public void initStock() {
		stockList = new ArrayList<Stock>();
		stockList.add(s1);
		stockList.add(s2);
	}

	@After
	public void destroyStock() {
		stockList = null;
	}

	@Test
	public void testStockSize() { // Testing if stock list populates correctly;
		assertNotNull(stockList);
		assertEquals(stockList.size(), 2);
	}

	@Test
	public void testGetStockByIsbn() { // Using isbn to search for a stock that
										// is specific to a book;

		assertEquals(s1, getStockByIsbn(isbn));
		assertEquals(s2, getStockByIsbn(1001342534));
		assertNotEquals(s1, getStockByIsbn(1001342534));
	}

	private Stock getStockByIsbn(long isbn) {

		for (Stock stock : stockList) {
			if (stock.getIsbn() == isbn) {
				return stock;
			}
		}
		return new Stock();
	}

	@Test
	public void testUpdateStock() { // Test if after a purchase the stock is
									// changing correctly;
		int newStock = 15;
		s2.setQuantity(s2.getQuantity() - 5);
		assertFalse(newStock == s2.getQuantity());

		newStock = 8;
		s1.setQuantity(s1.getQuantity() - 3); // decrease first stock/"book
												// stock" by 3;
		assertTrue(newStock == s1.getQuantity());

	}
}
