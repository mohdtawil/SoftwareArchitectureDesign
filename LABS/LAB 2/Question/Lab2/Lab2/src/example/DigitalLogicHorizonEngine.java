package example;

public class DigitalLogicHorizonEngine {
	private static final String companyName = "DigitalLogicHorizon";

	public DigitalLogicHorizonEngine() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	public void adjustThrottle() {
	}

	public String getProductInfo() {
		return " [" + companyName + " Engine] ";
	}

}
