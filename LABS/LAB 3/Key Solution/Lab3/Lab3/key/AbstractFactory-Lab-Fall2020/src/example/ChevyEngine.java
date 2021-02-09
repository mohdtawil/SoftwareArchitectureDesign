package example;

public class ChevyEngine implements IEngine {

	public ChevyEngine() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	@Override
	public void adjustThrottle() {
	}

	@Override
	public String getProductInfo() {
		return " [ Chevy Engine ] ";
	}

}
