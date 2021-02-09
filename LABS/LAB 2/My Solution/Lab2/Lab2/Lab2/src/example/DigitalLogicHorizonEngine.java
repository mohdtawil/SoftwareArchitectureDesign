package example;

public class DigitalLogicHorizonEngine extends DigitalLogicHorizonTypes {
	//private static final String companyName = "DigitalLogicHorizon";

	public DigitalLogicHorizonEngine() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	public void adjustThrottle() {
	}

        @Override
	public String getProductInfo() {
		return "Engine";
	}

}
