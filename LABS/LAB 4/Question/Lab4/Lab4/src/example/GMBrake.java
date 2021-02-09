package example;

public class GMBrake implements IBrake {
	
	public GMBrake() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	@Override
	public void stop() {
	}

	@Override
	public String getProductInfo() {
		return " [ GM Brake ] ";
	}
}
