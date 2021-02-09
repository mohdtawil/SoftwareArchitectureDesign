package example;

public interface ICruiseControlPartsFactory {

	public IBrake createBrake();

	public IEngine createEngine();

	public IShaft createShaft();
}
