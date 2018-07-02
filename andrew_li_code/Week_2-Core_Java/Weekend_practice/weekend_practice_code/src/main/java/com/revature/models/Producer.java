package com.revature.models;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Producer extends Thread {
	private ConcurrentLinkedQueue<Integer> destinationLine;
	private Consumer consumer;
	
	public Producer(ConcurrentLinkedQueue<Integer> k) {
		this.destinationLine = k;
	}
	
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	
	@Override
	public void run() {
		produce();
	}
	
	public void produce() {
		for (int i = 0;;) {
			double b = Math.random();
			b *= b;
			b *= b;
			b *= b;
			b *= b;
			b *= 1000000000;
			int k = (int) b;
				while (destinationLine.size() >= 1) {
					try {
						consumer.notify();
					} catch (IllegalMonitorStateException e) {
					}
					try {
						this.wait();
					} catch (InterruptedException e) {
					} catch (IllegalMonitorStateException e) {
					}
				}
			synchronized (destinationLine) {
				destinationLine.add(k);
				System.out.println("Producing item " + ++i
						+ " with value: " + k);
				try {
					consumer.notify();
				} catch (IllegalMonitorStateException e) {
				}
			}
		}
	}
	

}
