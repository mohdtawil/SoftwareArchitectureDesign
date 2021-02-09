package example;

public class SecondCombFactory implements ICruiseControlPartsFactory {

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
		return new GMShaft();
	}

}
