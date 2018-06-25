package w1r.procon.models;

public class Consumer extends ProCon {
	Object lock;
	
	Consumer() {
		
	}
	
	// Assigning lock for synchronized block
	public Consumer(Object obj){
		lock = obj;
	}
	
	// Consumer action: consume
	public void run() {
		while(true) {
			try {
				synchronized (lock) {
					if(size != 0) {
						buffer.removeFirst();
						size--;
						System.out.println("Consumer says, 'Size is " + buffer.size() + ".'");
		
						Thread.sleep(1000);
					} 
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
