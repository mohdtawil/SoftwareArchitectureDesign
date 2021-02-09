package example;

public class ChevyBrake implements IBrake {
	
	public ChevyBrake() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	@Override
	public void stop() {
	}

	@Override
	public String getProductInfo() {
		return " [ Chevy Brake ] ";
	}
}
