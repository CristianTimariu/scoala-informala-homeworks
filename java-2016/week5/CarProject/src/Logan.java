
public class Logan extends Dacia {
	
	private boolean airCondition;

	//Logan can have Air Condition, but influent's the consumption. If not consumption will be "standard" from Car class.
	
	public Logan(String chassisNumber, int fuelTank, String fuelType, int numberOfGears, float fuelLevel, boolean airCondition) {
		super(chassisNumber, fuelTank, fuelType, numberOfGears, fuelLevel);
		
	}


	public boolean isAirCondition() {
		return airCondition;
	}


	public void setAirCondition(boolean airCondition) {
		this.airCondition = airCondition;
	}


	@Override
	public float getAverageFuelConsumption() {
		if (airCondition == true){
		return (float) (consumedFuel / traveledDistance * 100 + consumedFuel*20/100);
		}
		else return (float) (consumedFuel / traveledDistance * 100);
	}
	
	@Override
	public float getAvailableFuel(){
		
		currentFuelAmmount = (float) (currentFuelAmmount - (traveledDistance*getAverageFuelConsumption()/100));
		return currentFuelAmmount;
		
	}
}
