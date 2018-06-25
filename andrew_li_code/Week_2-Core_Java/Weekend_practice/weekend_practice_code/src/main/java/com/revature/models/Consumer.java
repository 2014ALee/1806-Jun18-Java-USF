package com.revature.models;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Consumer extends Thread {
	private ConcurrentLinkedQueue<Integer> supplyLine;
	
	public Consumer(ConcurrentLinkedQueue<Integer> k) {
		this.supplyLine = k;
	}
	
	@Override
	public void run() {
		consume();
	}
	
	public void consume() {
		for (int i = 0;;) {
			synchronized (supplyLine) {
				while (supplyLine.size() == 0) {
					System.out.println("Supply line is empty!!!");
					try {
						this.wait();
						int k = supplyLine.poll();
						System.out.println("Consuming item " + ++i
								+ " with value: " + k);
						notify();
						System.out.println("Notified Producer!");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	

}
