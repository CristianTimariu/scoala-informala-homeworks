import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import ro.sci.client.Address;
import ro.sci.client.Cart;
import ro.sci.client.Customer;

public class TestCustomer {

	Customer customer = new Customer();
	Address address = new Address();
	Cart cart = new Cart();

	@Before
	public void initCustomer() {
		customer.setName("John");
		customer.setAddress(address);
		customer.setEmail("john@gmail.com");
		customer.setCart(cart);
	}

	@After
	public void destroyCustomer() {
		customer = null;
	}

	@Test
	public void testCustomer() {

		assertNull(customer);
		assertEquals("John", customer.getName());
	}

}
