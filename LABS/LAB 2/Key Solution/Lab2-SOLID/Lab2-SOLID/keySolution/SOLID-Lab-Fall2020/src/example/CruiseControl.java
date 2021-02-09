package example;

public class CruiseControl {

	private IBrake brake;
	private IEngine engine;
	private IShaft shaft;
	private IThrottle throttle;

	public CruiseControl(IBrake brake, IEngine engine, IShaft shaft, IThrottle throttle) {
		this.brake = brake;
		this.engine = engine;
		this.shaft = shaft;
		this.throttle = throttle;
	}

	public void printInfo() {
		System.out.println(brake.getProductInfo() + engine.getProductInfo() + shaft.getProductInfo()
				+ throttle.getProductInfo() + "\n");
	}
}
