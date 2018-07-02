package com.revature.models;

public class ThreadConsumer extends Thread {

	ProduceAndConsume pc;
	public ThreadConsumer(ProduceAndConsume pc) {
		this.pc = pc;
	}
	
	@Override
	public void run() {			// defines the logic to be executed by the thread
		pc.consume();
	}
}
