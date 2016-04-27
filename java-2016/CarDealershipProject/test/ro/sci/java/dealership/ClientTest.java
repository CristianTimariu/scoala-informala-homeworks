package ro.sci.java.dealership;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {

	BankAccount bankAccount;
	Client client;
	Address address;
	
	@Before
	public void setUp() {
		address = new Address("Brazilor", 22, "Aiud");
		bankAccount = new BankAccount("001", 20000);
		client = new Client("1234", "Tim", address, bankAccount);
	}

	@After
	public void tearDown() {
		address = null;
		bankAccount = null;
		client = null;
	}

	@Test
	public void testClientFields() {
		assertNotNull(client.getAddress());
		assertEquals(20000, client.getBankAccount().balance, 0);
		assertTrue("1234".equals(client.getId()));
		assertEquals("Tim", client.getName());
	}
}
