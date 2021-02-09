package example;

public class ChevyShaft implements IShaft {

	public ChevyShaft() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	@Override
	public String getProductInfo() {
		return " [ GM Shaft ] ";
	}
}
