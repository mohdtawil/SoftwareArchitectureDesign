package example;

public class Main {
	public static void main(String args[]) throws InterruptedException {

		System.out.println("Test Case 1: First combination");
		CruiseControl cruiseCtrl = new CruiseControl(new FirstCombFactory());
		System.out.println("Test Case 1 output: ");
		cruiseCtrl.printInfo();
		
		
		System.out.println("Test Case 2: Second combination");
		cruiseCtrl = new CruiseControl(new SecondCombFactory());
		System.out.println("Test Case 2 output: ");
		cruiseCtrl.printInfo();
	}
}
