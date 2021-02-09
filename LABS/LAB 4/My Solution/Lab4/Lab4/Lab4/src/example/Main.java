package example;

public class Main {
	public static void main(String args[]) throws InterruptedException {

		System.out.println("Start Main ...");
          
                
                // First Object
                
                IBrake brake1 = new GMBrake();
                IEngine engine1 = new GMEngine();
                IShaft shaft1 = new ChevyShaft();
               
                CruiseControl firstObject = new CruiseControlBuilder().buildBrake(brake1).buildEngine(engine1).buildShaft(shaft1).build();
                firstObject.printInfo();
                
                
                
                
                
                // Second Object
                
                IBrake brake2 = new GMBrake();
                IEngine engine2 = new GMEngine();
                IShaft shaft2 = new GMShaft();
                
                CruiseControl secondObject = new CruiseControlBuilder().buildBrake(brake2).buildEngine(engine2).buildShaft(shaft2).build();
                secondObject.printInfo();
                
                
                
                
	}
}
