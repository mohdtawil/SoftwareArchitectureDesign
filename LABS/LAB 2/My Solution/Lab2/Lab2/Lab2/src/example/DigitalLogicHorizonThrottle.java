package example;

public class DigitalLogicHorizonThrottle extends DigitalLogicHorizonTypes {

	//private static final String companyName = "DigitalLogicHorizon";

	public DigitalLogicHorizonThrottle() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

        @Override
	public String getProductInfo() {
		return "Throttle";
	}
}
