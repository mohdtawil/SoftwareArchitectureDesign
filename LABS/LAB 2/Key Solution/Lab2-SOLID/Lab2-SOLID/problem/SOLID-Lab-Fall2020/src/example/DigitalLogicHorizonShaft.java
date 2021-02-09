package example;

public class DigitalLogicHorizonShaft {

	private static final String companyName = "DigitalLogicHorizon";

	public DigitalLogicHorizonShaft() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	public String getProductInfo() {
		return " [" + companyName + " shaft] ";
	}
}
