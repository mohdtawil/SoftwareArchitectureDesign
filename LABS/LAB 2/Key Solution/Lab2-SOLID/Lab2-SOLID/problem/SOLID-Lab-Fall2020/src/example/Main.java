package example;

public class Main {
	public static void main(String args[]) throws InterruptedException {

		System.out.println("Start Main ...");

		DigitalLogicHorizonBrake brake = new DigitalLogicHorizonBrake();
		DigitalLogicHorizonEngine engine = new DigitalLogicHorizonEngine();
		DigitalLogicHorizonShaft shaft = new DigitalLogicHorizonShaft();
		DigitalLogicHorizonThrottle throttle = new DigitalLogicHorizonThrottle();

		CruiseControl cruiseCtrl = new CruiseControl(brake, engine, shaft, throttle);
		cruiseCtrl.printInfo();
	}
}
