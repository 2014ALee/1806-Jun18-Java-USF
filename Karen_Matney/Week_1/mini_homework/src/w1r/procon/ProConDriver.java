package w1r.procon;

import java.util.LinkedList;
import w1r.procon.models.*;

public class ProConDriver {
	
	public static void main(String[] args) {
		int size;											// current size
		int maxSize;										// Bound
		LinkedList<Integer> buffer = new LinkedList<>();	// Shared resource
		Object lock = new Object();							// Lock for synchronized blocks
		
		size = 0;		// Insatiated to zero at first
		maxSize = 10;
		
		ProCon setup = new ProCon(size,maxSize,buffer);
		Producer producer = new Producer(lock);
		Consumer consumer = new Consumer(lock);
		
		producer.start();
		consumer.start();
	}
}