package example;

public class GMEngine implements IEngine {

	public GMEngine() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	@Override
	public void adjustThrottle() {
	}

	@Override
	public String getProductInfo() {
		return " [ GM Engine ] ";
	}

}
