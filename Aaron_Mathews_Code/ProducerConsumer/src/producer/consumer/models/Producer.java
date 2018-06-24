package producer.consumer.models;

public class Producer extends ProducerConsumer {
	
	@Override 
	//Calling start() on user objs will call run() on the individual 
	public void run() {
		try {
			produce();
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted while producing.");
		}
	}
}