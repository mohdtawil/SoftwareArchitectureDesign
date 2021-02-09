package example;

public class DigitalLogicHorizonBrake extends DigitalLogicHorizonTypes {
	//private static final String companyName = "DigitalLogicHorizon";

	public DigitalLogicHorizonBrake() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	public void stop() {
            
	}
        
        @Override
	public String getProductInfo() {
		return "Brake";
	}
}
