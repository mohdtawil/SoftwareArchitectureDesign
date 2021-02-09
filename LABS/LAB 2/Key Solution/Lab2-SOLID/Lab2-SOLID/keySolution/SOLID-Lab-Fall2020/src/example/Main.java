package example;

public class Main {
	public static void main(String args[]) throws InterruptedException {

		System.out.println("Start Main ...");

		IBrake brake = new DigitalLogicHorizonBrake();
		IEngine engine = new DigitalLogicHorizonEngine();
		IShaft shaft = new DigitalLogicHorizonShaft();
		IThrottle throttle = new DigitalLogicHorizonThrottle();

		CruiseControl cruiseCtrl = new CruiseControl(brake, engine, shaft, throttle);
		cruiseCtrl.printInfo();

	}
}
