package com.revature;

import java.util.LinkedList;

public class Processor {
	
	private LinkedList<Integer> list = new LinkedList<>();
	private int limit = 3;
	private Object lock = new Object();
	
	public void producer() throws InterruptedException {
		int value = 0;
		
		while(true) {
			
			synchronized(lock) {
				
				while(list.size() == limit) {
					lock.wait();
				}
				
				list.add(value++);
				lock.notify();
			}
		}
	}
	
	public void consumer() throws InterruptedException {
		int value = 0;
		while(true) {
			
			synchronized(lock) {
				
				while(list.size() == 0) {
					lock.wait();
				}
				System.out.print("Produce: " + list.size());
				value = list.removeFirst();
				System.out.println("; Consume: " +value);
				lock.notify();
			}
			
			Thread.sleep(1000);
		}
	}
}
