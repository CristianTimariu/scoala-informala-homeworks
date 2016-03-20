
public class Duster extends Dacia {

	private float tireWidth; // Duster have tire width in plus, which influent's the fuel consumption.

	public Duster(String chassisNumber, int fuelTank, String fuelType, int numberOfGears, float fuelLevel, float anvelopeWidth) {
		super(chassisNumber, fuelTank, fuelType, numberOfGears, fuelLevel);
		this.setAnvelopeWidth(anvelopeWidth);
	}

	public float getAnvelopeWidth() {
		return tireWidth;
	}

	public void setAnvelopeWidth(float anvelopeWidth) {
		this.tireWidth = anvelopeWidth;
	}

	@Override
	public float getAverageFuelConsumption() {
		if (tireWidth>200){
		return (float) (consumedFuel / traveledDistance * 100 + consumedFuel*10/100);
		}
		else return (float) (consumedFuel / traveledDistance * 100 + consumedFuel*5/100);
	}
	
	@Override
	public float getAvailableFuel(){
		
		currentFuelAmmount = (float) (currentFuelAmmount - (traveledDistance*getAverageFuelConsumption()/100));
		return currentFuelAmmount;
		
	}
		
	
}
