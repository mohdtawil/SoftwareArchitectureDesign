package example;

public class DigitalLogicHorizonBrake {
	private static final String companyName = "DigitalLogicHorizon";

	public DigitalLogicHorizonBrake() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	public void stop() {
	}

	public String getProductInfo() {
		return " [" + companyName + " Brake] ";
	}
}
