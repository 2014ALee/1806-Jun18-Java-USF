package producer.consumer;


import producer.consumer.models.Consumer;
import producer.consumer.models.Producer;

public class ThreadDriver {
	
	public static void main(String[] args) {
		
		Producer prod = new Producer();
		Consumer cons = new Consumer();
		
		prod.setName("Prod");
		cons.setName("Cons");
		
		prod.start();
		cons.start();
		
		/*try {
			prod.join();
			cons.join();
		} catch (InterruptedException ie) {
			System.out.println("Program was interrupted.");
		}*/
	}

}
