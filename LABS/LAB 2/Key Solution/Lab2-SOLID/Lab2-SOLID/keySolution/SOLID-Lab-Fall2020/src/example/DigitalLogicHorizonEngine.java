package example;

public class DigitalLogicHorizonEngine implements IEngine {
	private static final String companyName = "DigitalLogicHorizon";

	public DigitalLogicHorizonEngine() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	@Override
	public void adjustThrottle() {
	}

	@Override
	public String getProductInfo() {
		return " [" + companyName + " " + productName + "] ";
	}

}
