package com.revature;

import com.revature.models.*;

public class ThreadDriver {

	public static void main(String[] args) {
		
		ProduceAndConsume pc = new ProduceAndConsume();
		
		ThreadProducer producerThread = new ThreadProducer(pc);
		ThreadConsumer consumerThread = new ThreadConsumer(pc);
		
		producerThread.start();
		consumerThread.start();
		
		try {
			producerThread.join();
			consumerThread.join();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
}
