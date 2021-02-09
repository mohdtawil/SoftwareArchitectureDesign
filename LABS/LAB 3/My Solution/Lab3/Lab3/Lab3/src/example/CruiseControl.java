package example;

public class CruiseControl {

	private IBrake brake;
	private IEngine engine;
	private IShaft shaft;

	public CruiseControl(CombinationPartsFactory compainnationPart) {
		brake = compainnationPart.createBrake();
		engine = compainnationPart.createEngine();
		shaft = compainnationPart.createShaft();
	}

	public void printInfo() {
		System.out.println(brake.getProductInfo() + engine.getProductInfo() + shaft.getProductInfo() + "\n");
	}
}
