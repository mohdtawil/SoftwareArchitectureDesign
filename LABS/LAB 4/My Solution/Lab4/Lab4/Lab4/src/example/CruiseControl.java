package example;

public class CruiseControl {

	private IBrake brake;
	private IEngine engine;
	private IShaft shaft;

	public CruiseControl(IBrake brake, IEngine engine, IShaft shaft) {
            this.brake = brake;
            this.engine = engine;
            this.shaft = shaft;
	}

	public void printInfo() {
		System.out.println(brake.getProductInfo() + engine.getProductInfo() + shaft.getProductInfo() + "\n");
	}
}
