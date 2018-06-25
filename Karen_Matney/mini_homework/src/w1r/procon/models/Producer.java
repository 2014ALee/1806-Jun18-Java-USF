package w1r.procon.models;

public class Producer extends ProCon {
	Object lock;

	Producer() {

	}

	// Assign lock for synchronized block
	public Producer(Object obj){
		lock = obj;
	}

	// Producer action: produce
	public void run() {
		while(true) {
			try {
				synchronized (lock) {
					if(size != maxSize) {
						buffer.add(1);
						size++;
						System.out.println("Producer says, 'Size is " + buffer.size() + ".'");
						
						Thread.sleep(1000);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
