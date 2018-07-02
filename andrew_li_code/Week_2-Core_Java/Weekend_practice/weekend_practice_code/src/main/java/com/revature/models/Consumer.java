package com.revature.models;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Consumer extends Thread {
	private ConcurrentLinkedQueue<Integer> supplyLine;
	private Producer producer;
	
	public Consumer(ConcurrentLinkedQueue<Integer> k) {
		this.supplyLine = k;
	}
	
	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	
	@Override
	public void run() {
		consume();
	}
	
	public void consume() {
		for (int i = 0;;) {
				while (supplyLine.size() == 0) {
					try {
						producer.notify();
					} catch (IllegalMonitorStateException e) {
					}
					try {
						this.wait();
					} catch (InterruptedException e) {
					} catch (IllegalMonitorStateException e) {
					}
				}
			synchronized (supplyLine) {
				int k = supplyLine.poll();
				System.out.println("Consuming item " + ++i
						+ " with value: " + k);
				try {
					producer.notify();
				} catch (IllegalMonitorStateException e) {
				}
			}
		}
	}
	

}
