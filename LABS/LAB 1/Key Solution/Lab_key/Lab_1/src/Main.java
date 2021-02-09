import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		final int size = 1000;
		int numbers[] = new int[size];
		
		int originalSum = 0;
		for (int i=0; i<numbers.length; i++) {
			numbers[i] = i;
                       	}
                
                for (int i=0; i<numbers.length; i++)
                   if(numbers[i]%2==0)
			originalSum = originalSum + numbers[i];
	  
		
		System.out.println("Original Sum = " + originalSum);
		
		List<AdderThread> threads = new ArrayList<AdderThread>();
		
		threads.add(new AdderThread(0, size/2, numbers));
		threads.add(new AdderThread(size/2, size-1, numbers));
		
		for (AdderThread t : threads) {
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		int threadsSum = 0;
		for (AdderThread t : threads) {
			threadsSum = t.getSum() + threadsSum;
		}
		System.out.println("threadsSum = " + threadsSum);
	}
}
