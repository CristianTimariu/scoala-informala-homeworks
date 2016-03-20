
public class VehicleTestApp {

	public static void main(String[] args) {

		/*
		 * Here I run some examples with all types of cars. All examples have
		 * the same methods implemented.
		 */

		System.out.println("Logan \n------");
		Car logan1 = new Logan("345efrdg43", 55, "GAS", 5, 15, true); // Here I
																		// have
																		// some
																		// mistake!
																		// true
																		// doesn't
																		// influent
																		// the
																		// boolean
		logan1.start();
		logan1.shiftGear(1);
		logan1.drive(0.2);
		logan1.shiftGear(2);
		logan1.drive(0.2);
		logan1.shiftGear(3);
		logan1.drive(1.2);
		logan1.shiftGear(4);
		logan1.drive(3);
		logan1.shiftGear(5);
		logan1.drive(100);
		logan1.shiftGear(2);
		logan1.drive(0.5);
		logan1.stop();

		float availableFuel = logan1.getAvailableFuel();
		System.out.println("Available fuel: " + availableFuel);
		float fuelConsumedPer100Km = logan1.getAverageFuelConsumption();
		System.out.println("Average consumption: " + fuelConsumedPer100Km);

		System.out.println("\nDuster - 220 tire width \n------------");
		Car duster = new Duster("345efrdg43", 65, "GAS", 5, 15, 220);
		duster.start();
		duster.shiftGear(1);
		duster.drive(0.2);
		duster.shiftGear(2);
		duster.drive(0.2);
		duster.shiftGear(3);
		duster.drive(1.2);
		duster.shiftGear(4);
		duster.drive(3);
		duster.shiftGear(5);
		duster.drive(100);
		duster.shiftGear(2);
		duster.drive(0.5);
		duster.stop();

		availableFuel = duster.getAvailableFuel();
		System.out.println("Available fuel: " + availableFuel);
		fuelConsumedPer100Km = duster.getAverageFuelConsumption();
		System.out.println("Average consumption: " + fuelConsumedPer100Km);

		System.out.println("\nDuster - 190 tire width \n------------");
		Car duster1 = new Duster("345efrdg43", 65, "GAS", 5, 15, 190);
		duster1.start();
		duster1.shiftGear(1);
		duster1.drive(0.2);
		duster1.shiftGear(2);
		duster1.drive(0.2);
		duster1.shiftGear(3);
		duster1.drive(1.2);
		duster1.shiftGear(4);
		duster1.drive(3);
		duster1.shiftGear(5);
		duster1.drive(100);
		duster1.shiftGear(2);
		duster1.drive(0.5);
		duster1.stop();

		availableFuel = duster1.getAvailableFuel();
		System.out.println("Available fuel: " + availableFuel);
		fuelConsumedPer100Km = duster1.getAverageFuelConsumption();
		System.out.println("Average consumption: " + fuelConsumedPer100Km);

		System.out.println("\nGolf - 1.4 Cubic Capacity \n------------");
		Car golf = new VWGolf("345efrdg43", 60, "Gas", 5, 15);
		golf.start();
		golf.shiftGear(1);
		golf.drive(0.2);
		golf.shiftGear(2);
		golf.drive(0.2);
		golf.shiftGear(3);
		golf.drive(1.2);
		golf.shiftGear(4);
		golf.drive(3);
		golf.shiftGear(5);
		golf.drive(100);
		golf.shiftGear(2);
		golf.drive(0.5);
		golf.stop();

		availableFuel = golf.getAvailableFuel();
		System.out.println("Available fuel: " + availableFuel);
		fuelConsumedPer100Km = golf.getAverageFuelConsumption();
		System.out.println("Average consumption: " + fuelConsumedPer100Km);

		System.out.println("\nPassat - 1.9 Cubic Capacity \n------------");
		Car passat = new VWPassat("345efrdg43", 60, "DIESEL", 5, 15);
		passat.start();
		passat.shiftGear(1);
		passat.drive(0.2);
		passat.shiftGear(2);
		passat.drive(0.2);
		passat.shiftGear(3);
		passat.drive(1.2);
		passat.shiftGear(4);
		passat.drive(3);
		passat.shiftGear(5);
		passat.drive(100);
		passat.shiftGear(2);
		passat.drive(0.5);
		passat.stop();

		availableFuel = passat.getAvailableFuel();
		System.out.println("Available fuel: " + availableFuel);
		fuelConsumedPer100Km = passat.getAverageFuelConsumption();
		System.out.println("Average consumption: " + fuelConsumedPer100Km);

		/*
		 * Next is the task implemented.
		 */

		int currentFuelAmmount = 27;
		String chasseNumber = "oiqe0934hkkadsn";

		Car car = new Logan(chasseNumber, 60, "DIESEL", 5, currentFuelAmmount, false); // Logan
																						// can
																						// extend
																						// from
																						// Dacia,
																						// while
																						// Dacia
																						// extends
																						// from
																						// Car

		car.start();

		car.shiftGear(1);

		car.drive(0.01);// drives 0.01 KMs

		car.shiftGear(2);

		car.drive(0.02);

		car.shiftGear(3);

		car.drive(0.5);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(5);

		car.drive(10);

		car.shiftGear(4);

		car.drive(0.5);

		car.shiftGear(3);

		car.drive(0.1);

		car.stop();

		float availableFuel11 = car.getAvailableFuel(); // this value must be
														// smaller than the
														// initial value passed
														// in the constructor

		System.out.println("Available fuel: " + availableFuel11);
		float fuleConsumedPer100Km11 = car.getAverageFuelConsumption();
		System.out.println("Average fuel: " + fuleConsumedPer100Km11);

		Vehicle vehicle = new VWGolf("1987ddkshik289", 60, "DIESEL", 5, 30); // available
																				// fuel
																				// and
																				// Chases
																				// number

		vehicle.start();

		vehicle.drive(1);

		vehicle.stop();

		Car car2 = (Car) vehicle;

		 float availableFuel1 = car2.getAvailableFuel();
		 System.out.println("Available fuel: " + availableFuel1);
		
		 float fuleConsumedPer100Km1 = car2.getAverageFuelConsumption();
		 System.out.println("Average consumption: " + fuleConsumedPer100Km1);

	}
}