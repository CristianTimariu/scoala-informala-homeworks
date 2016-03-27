import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import ro.sci.client.Cart;
import ro.sci.client.Customer;
import ro.sci.shop.Book;
import ro.sci.shop.Stock;

/**
 * 
 */

/**
 * @author Timy
 *
 */
public class TestCart {

	List<Book> catalog = null;
	List<Stock> stockList = null;

	Cart cart = new Cart();
	Customer customer = new Customer();

	Stock s1 = new Stock(30, 120213342);
	Book b1 = new Book("AAA", "aaa", "Adventure", 120213342, s1);

	@Before
	public void initCatalog() {
		catalog = new ArrayList<Book>();
		catalog.add(b1);
	}

	@Before
	public void initStocklist() {
		stockList = new ArrayList<Stock>();
		stockList.add(s1);
	}

	@Before
	public void initCustomer() {
		customer.setCart(cart);
	}

	@Test
	public void testInitCart() {
		assertNotNull(cart);
	}

	@Test
	public void testCartPopulate() {
		customer.addToCart("AAA", 3);

		// assertEquals((Object)(cart.getBooks()), (Object)(b1));
		assertEquals(27, s1.getQuantity()); // addToCart method has bugs. I have
											// mistakes.
		// this is how far I came with homework

	}

}
