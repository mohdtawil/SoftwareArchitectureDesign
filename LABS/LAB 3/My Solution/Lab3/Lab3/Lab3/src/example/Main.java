package example;

public class Main {
	public static void main(String args[]) throws InterruptedException {
            
            
                CruiseControl cruisecontrol;
                System.out.println("----- First combination -----");
                cruisecontrol = new CruiseControl(new FirstCombinationFactory());
                cruisecontrol.printInfo();
                
                System.out.println("************************************************");
                
                System.out.println("----- Second combination -----");
                cruisecontrol = new CruiseControl(new SecondCombinationFactory());
                cruisecontrol.printInfo();
	}
}
