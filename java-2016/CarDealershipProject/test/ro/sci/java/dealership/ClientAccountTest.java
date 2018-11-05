package ro.sci.java.dealership;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.sci.java.vehicle.Car;
import ro.sci.java.vehicle.Duster;
import ro.sci.java.vehicle.Logan;

public class ClientAccountTest {

	Client client1;
	ClientAccount clientAccount;
	Car logan;
	Car duster;
	Car logan1;

	@Before
	public void setUp() throws Exception {
		// given
		client1 = new Client("001", "John", null, null);
		clientAccount = new ClientAccount(client1.getName());
		logan = new Logan("aaaaa", 2015, 4500, 4.5);
		duster = new Duster("bbbbb", 2013, 5000, 8.8);
		logan1 = new Logan("ccccc", 2009, 2000, 6.4);
	}

	@After
	public void tearDown() throws Exception {
		client1 = null;
		clientAccount = null;
		logan = null;
		duster = null;
	}

	@Test
	public void testClientFleetPopulates() {
		clientAccount.addCarToFleet(logan);
		clientAccount.addCarToFleet(duster);
		// when
		List<Car> clientCars = clientAccount.getFleet();
		// then
		assertTrue(!clientCars.isEmpty());
		assertEquals(2, clientCars.size());
	}

	@Test
	public void testRemoveCarFromFleet() {
		// given
		clientAccount.addCarToFleet(duster);
		clientAccount.addCarToFleet(logan);
		// when
		clientAccount.removeCarFromFleet(duster);
		List<Car> clientCars = clientAccount.getFleet();
		// then
		assertNotEquals(2, clientCars.size());
		assertFalse(clientCars.contains(duster));
	}

	@Test
	public void testSortingClientCarsByProductionYear() {
		clientAccount.addCarToFleet(duster);
		clientAccount.addCarToFleet(logan);
		clientAccount.addCarToFleet(logan1);
		// when
		List<Car> sortByYearList;
		sortByYearList = clientAccount.myFleet(Car.CarComparator.SORT_BY_YEAR);
		// then
		assertTrue(sortByYearList.get(0).getYear() < sortByYearList.get(1).getYear());
		assertTrue(sortByYearList.get(1).getYear() < sortByYearList.get(2).getYear());
	}

	@Test
	public void testSortingClientCarsByFuelConsumption() {
		clientAccount.addCarToFleet(duster); // 8.8
		clientAccount.addCarToFleet(logan); // 4.5
		clientAccount.addCarToFleet(logan1); // 6.4
		assertNotEquals(4.5, clientAccount.getFleet().get(0)); // 4.5 wasn't at
																// position 0.

		// when
		List<Car> sortByAverageConsumption;
		sortByAverageConsumption = clientAccount.myFleet(Car.CarComparator.SORT_BY_FUEL_EFFICIENCY);
		// then
		assertEquals(4.5, sortByAverageConsumption.get(0).getAverageConsumption(), 0);
		// after comparator 4.5 is at position 0.
		assertTrue(sortByAverageConsumption.get(0).getAverageConsumption() < sortByAverageConsumption.get(1)
				.getAverageConsumption());
		assertTrue(sortByAverageConsumption.get(1).getAverageConsumption() < sortByAverageConsumption.get(2)
				.getAverageConsumption());
	}
}
