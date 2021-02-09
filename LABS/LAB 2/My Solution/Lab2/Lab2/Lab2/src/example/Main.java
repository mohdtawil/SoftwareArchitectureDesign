package example;

public class Main {
	public static void main(String args[]) throws InterruptedException {

		System.out.println("Start Main ...");
                
                DigitalLogicHorizonTypes DLHT = new DigitalLogicHorizonTypes();

		CruiseControl cruiseCtrl = new CruiseControl(DLHT);
		cruiseCtrl.printInfo(DLHT);
	}
}
