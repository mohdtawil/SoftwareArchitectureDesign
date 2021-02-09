package example;

public class FirstCombFactory implements ICruiseControlPartsFactory {

	@Override
	public IBrake createBrake() {
		return new GMBrake();
	}

	@Override
	public IEngine createEngine() {
		return new GMEngine();
	}

	@Override
	public IShaft createShaft() {
		return new ChevyShaft();
	}

}
