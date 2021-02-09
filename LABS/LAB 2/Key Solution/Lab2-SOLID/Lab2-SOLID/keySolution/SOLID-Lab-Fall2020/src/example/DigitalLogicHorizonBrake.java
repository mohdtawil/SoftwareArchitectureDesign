package example;

public class DigitalLogicHorizonBrake implements IBrake {
	private static final String companyName = "DigitalLogicHorizon";

	public DigitalLogicHorizonBrake() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	@Override
	public void stop() {
	}

	@Override
	public String getProductInfo() {
		return " [" + companyName + " " + productName + "] ";
	}
}
