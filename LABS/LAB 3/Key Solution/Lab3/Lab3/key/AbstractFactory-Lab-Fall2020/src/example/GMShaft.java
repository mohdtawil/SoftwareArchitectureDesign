package example;

public class GMShaft implements IShaft {

	public GMShaft() {
		System.out.println("Created instance of class " + this.getClass().getSimpleName());
	}

	@Override
	public String getProductInfo() {
		return " [ GM Shaft ] ";
	}
}
