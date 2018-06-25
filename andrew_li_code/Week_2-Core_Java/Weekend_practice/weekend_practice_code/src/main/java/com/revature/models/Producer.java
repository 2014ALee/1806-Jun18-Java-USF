package com.revature.models;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Producer extends Thread {
	private ConcurrentLinkedQueue<Integer> destinationLine;
	
	public Producer(ConcurrentLinkedQueue<Integer> k) {
		this.destinationLine = k;
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
			synchronized (destinationLine) {
				while (destinationLine.size() >= 10) {
					System.out.println("Distribution line is full!!");
					try {
						this.wait();
						destinationLine.add(k);
						System.out.println("Producing item " + ++i
								+ " with value: " + k);
						notify();
						System.out.println("Notified Consumer!");
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						System.out.println("Access blocked!!!");
						e.printStackTrace();
					}
				}
			}
		}
	}
	

}
