public class AdderThread extends Thread {

	private int start;
	private int end;
	private int sum = 0;
	private int[] array;

	public AdderThread(int start, int end, int array[]) {
		this.start = start;
		this.end = end;
		this.array = array;
	}

	public int getSum() {
		return sum;
	}

	@Override
	public void run() {
		for (int i = start; i < end; i++) {
                    if(array[i]%2==0)
			sum = sum + array[i];
		}
	}
}
