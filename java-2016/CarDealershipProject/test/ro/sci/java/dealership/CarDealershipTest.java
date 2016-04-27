package ro.sci.java.dealership;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.sci.java.vehicle.Car;
import ro.sci.java.vehicle.Logan;
import ro.sci.java.vehicle.VWGolf;

public class CarDealershipTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCarDealershipCarListNotEmpty() {
		// given
		CarDealership carDealership = new CarDealership("compexit");
		Car logan = new Logan("aaaaa", 2015, 4500);
		Car vwGolf = new VWGolf("bbbbb", 2014, 8500);
		carDealership.addToStock(logan, 0);
		carDealership.addToStock(vwGolf, 0);
		// when
		List<Car> cars = carDealership.listAllCars();
		//then
		assertTrue(!cars.isEmpty());
	}
	
	@Test
	public void testCarDealershipCarListContainsCorrectNumberOfCars() {
		// given
		CarDealership carDealership = new CarDealership("compexit");
		Car logan = new Logan("aaaaa", 2015, 4500);
		Car vwGolf = new VWGolf("bbbbb", 2014, 8500);
		carDealership.addToStock(logan, 0);
		carDealership.addToStock(vwGolf, 0);
		// when
		List<Car> cars = carDealership.listAllCars();
		//then
		assertTrue(cars.size() == 2);
	}
	
	@Test
	public void testCarDealershipCarListDoesNotContainDuplicates() {
		// given
		CarDealership carDealership = new CarDealership("compexit");
		Car logan = new Logan("aaaaa", 2015, 4500);
		Car vwGolf = new VWGolf("bbbbb", 2014, 8500);
		
		carDealership.addToStock(logan, 0);
		carDealership.addToStock(vwGolf, 0);
		carDealership.addToStock(vwGolf, 0);
		// when
		List<Car> cars = carDealership.listAllCars();
		//then
		assertTrue(cars.size() == 2);
	}
	
	@Test
	public void testExternalModificationOfCarDealershipDoNotAffectInternalStructure() {
		CarDealership carDealership = new CarDealership("compexit");
		Car logan = new Logan("aaaaa", 2015, 4500);
		Car vwGolf = new VWGolf("bbbbb", 2014, 8500);
		Car vwGolf1 = new VWGolf("cccc", 2014, 8200);
		carDealership.addToStock(logan, 0);
		carDealership.addToStock(vwGolf, 0);
		carDealership.addToStock(vwGolf1, 0);

		// when
		List<Car> cars = carDealership.listAllCars();
		cars.remove(logan);
		//then
		assertEquals(3, carDealership.listAllCars().size());
	}

}
