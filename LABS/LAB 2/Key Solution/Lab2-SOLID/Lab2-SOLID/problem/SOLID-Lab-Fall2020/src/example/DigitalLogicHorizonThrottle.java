package example;

public class DigitalLogicHorizonThrottle {

	private static final String companyName = "DigitalLogicHorizon";

	public DigitalLogicHorizonThrottle() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	public String getProductInfo() {
		return " [" + companyName + " Throttle] ";
	}
}
