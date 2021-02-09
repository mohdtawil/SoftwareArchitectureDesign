package example;

public class DigitalLogicHorizonShaft extends DigitalLogicHorizonTypes {

	//private static final String companyName = "DigitalLogicHorizon";

	public DigitalLogicHorizonShaft() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

        @Override
	public String getProductInfo() {
		return "shaft";
	}
}
