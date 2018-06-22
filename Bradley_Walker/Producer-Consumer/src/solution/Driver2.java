package solution;

import java.util.LinkedList;

public class Driver2 {
	// Synchronized access

	public static void main(String[] args) {
		// Create the PC object which contains the consume and produce methods
		PC pc = new Driver2.PC();

		Thread producer = new Thread() {
			@Override
			public void run() {
				try {
					pc.produce();
//					Thread.sleep((long) (Math.random() * 100));
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		};

		Thread consumer = new Thread() {
			@Override
			public void run() {
				try {
					pc.consume();
//					Thread.sleep((long) (Math.random() * 100));
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		};

		producer.start();
		consumer.start();
	}

	private static class PC {
		// The PC class has the intrinsic lock. This is what the threads need to be able to run
		// the synchronized blocks.
		
		private LinkedList<Double> list = new LinkedList<>();
		private int maxSize = 100;

		public void produce() throws InterruptedException {
			double value;
			while(true) {
				// If a thread tries to execute this while another thread has the
				// intrinsic lock for the PC object, it will be blocked. If no
				// other thread has the intrinsic lock, this thread will get it
				// and will be allowed to access the synchronized block.
				synchronized(this) {
					while(list.size() == maxSize)
						wait(); // wait for notification

					value = 100 * Math.random();
					System.out.println("Producer produced " + value);

					list.add(value);

					// If the other thread is waiting for the lock, notify it
					notify();

					Thread.sleep((long) (Math.random() * 100));
				}
				// The lock is released at the end of the synchronized block
			}
		}

		public void consume() throws InterruptedException {
			double value;
			while(true) {
				synchronized(this) {
					while(list.size() == 0)
						wait();

					value = list.removeFirst();

					System.out.println("Consumer consumed " + value);

					notify();

					Thread.sleep((long) (Math.random() * 100));
				}
			}
		}
	}

}
