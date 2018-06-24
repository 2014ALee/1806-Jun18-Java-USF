package producer.consumer.models;

public class Consumer extends ProducerConsumer {

	@Override 
	//Calling start() on user objs will call run() on the individual 
	public void run() {
		try {
			consume();
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted while producing.");
		}
	} 
}