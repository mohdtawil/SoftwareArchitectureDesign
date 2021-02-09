package example;

public class DigitalLogicHorizonShaft implements IShaft {

	private static final String companyName = "DigitalLogicHorizon";

	public DigitalLogicHorizonShaft() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	@Override
	public String getProductInfo() {
		return " [" + companyName + " " + productName + "] ";
	}
}
