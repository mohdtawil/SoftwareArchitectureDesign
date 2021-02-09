package example;

public class CruiseControl {

	private DigitalLogicHorizonBrake brake;
	private DigitalLogicHorizonEngine engine;
	private DigitalLogicHorizonShaft shaft;
	private DigitalLogicHorizonThrottle throttle;

	public CruiseControl(DigitalLogicHorizonBrake brake, DigitalLogicHorizonEngine engine,
			DigitalLogicHorizonShaft shaft, DigitalLogicHorizonThrottle throttle) {
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
