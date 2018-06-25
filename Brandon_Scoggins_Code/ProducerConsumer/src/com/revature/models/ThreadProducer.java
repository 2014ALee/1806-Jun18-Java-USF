package com.revature.models;

public class ThreadProducer extends Thread {
	
	ProduceAndConsume pc;
	public ThreadProducer(ProduceAndConsume pc) {
		this.pc = pc;
	}
	
	@Override
	public void run() {			// defines the logic to be executed by the thread
		pc.produce();
	}
}
