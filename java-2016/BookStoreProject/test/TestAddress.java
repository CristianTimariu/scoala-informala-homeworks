
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.sci.client.Address;
import ro.sci.client.Customer;

public class TestAddress {

	Address address1 = new Address();
	Address address2 = new Address();

	Customer customer1 = new Customer("Bob", "@", address1, null);

	@Before
	public void initAddress() {

		address1.setStreet("street");
		address1.setNumber(1);
		address1.setCity("city");

		address2.setNumber(-3);
	}
	
	@After
	public void destroyCustomer() {
		customer1 = null;
	}

	@Test
	public void testCustomerAddress() { // Test address for null & print method;
		assertNotNull(customer1.getAddress());
		String s = "street";
		assertEquals(s, customer1.address.getStreet());
	}

	@Test
	public void testAddressNumber() { // Address number must be positive;
		assertTrue(customer1.address.getNumber() > 0);
		assertFalse(address2.getNumber() > 0);

		address1.setNumber(-3); // Address field "number" is set to negative
								// value;
		int number = address1.getNumber();
		address1.getPositiveAddressNumber(number);
		assertNotEquals(0, number);
	}

}
