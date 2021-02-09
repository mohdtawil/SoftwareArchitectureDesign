package example;

public class CruiseControl {

	private IBrake brake;
	private IEngine engine;
	private IShaft shaft;

	public CruiseControl(ICruiseControlPartsFactory factory) {
		this.brake = factory.createBrake();
		this.engine = factory.createEngine();
		this.shaft = factory.createShaft();
	}

	public void printInfo() {
		System.out.println(brake.getProductInfo() + engine.getProductInfo() + shaft.getProductInfo() + "\n");
	}
}
