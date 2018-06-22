package solution;

import java.util.*;

public class Driver {

	public static void main(String[] args) {
		// Use Vector class because it's thread-safe
//		ArrayList<Double> buffer = new ArrayList<>();
		Vector<Double> buffer = new Vector<>();
		// Set the maximum size of the buffer
		int maxSize = 100;
		
		/*
		 * The producer thread will generate random numbers and add them to the
		 * buffer as fast as it can
		 */
		Thread producer = new Thread() {
			@Override
			public void run() {
				while(true) {
					if(buffer.size() < maxSize)
						buffer.add(Math.random() * 100);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		/*
		 * The consumer thread will check the buffer as fast as it can and remove
		 * a number when it appears.
		 */
		Thread consumer = new Thread() {
			@Override
			public void run() {
				while(true)
					if(buffer.size() != 0)
						System.out.println(buffer.remove(0));
			}
		};
		
		producer.start();
		consumer.start();
	}

}
