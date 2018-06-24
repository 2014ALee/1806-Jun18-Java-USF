package producer.consumer.models;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer extends Thread {
	
	//Create list that will be used to store and represent resources
	List<Integer> resource = new ArrayList<>();
	public final int CAPACITY = 2;

	public void produce() throws InterruptedException {
		int value = 0;
		
		//System.out.println("Produce function called");
		
		while (true) {
			
			//Sync. keyword guarantees the thread will finish before other threads have access
			synchronized (this) {
				
				//If the resource is at capacity, the thread waits for resources to be consumed
				if (resource.size() == CAPACITY) {
					this.wait();
				}
				System.out.println("Producer has produced " + value);
				//System.out.println(resource.size());
				
				//While the resource is not full, add values to it
				resource.add(value++);
				
				//Notify the other threads that there are resources to be consumed
				notify();
				System.out.println("Consumer has been notified");
				
				// makes the working of program easier
                // to  understand
                Thread.sleep(1000);
			}
		}
	}
	
	public void consume() throws InterruptedException {
		int value; 
		
		//System.out.println("Consume function called");
		
		while (true) {
			
			//System.out.println("Consuming");
			
			synchronized (this) {
				
				//While the resource is empty, continue to wait. There is nothing to consume
				//System.out.println(resource.size());
				if (resource.size() == 0) {
					wait();
				}
				
				//Consume the first element and set its value to the int "value". It will be printed
				value = resource.remove(0);
				System.out.println("Consumer has removed " + value);
				
				//Notify producer on each iteration
				//Works as a check to see if process is done
				notify();
				
				// makes the working of program easier
                // to  understand
                Thread.sleep(1000);
			}
		}
	}

}
