package com.revature.models;

import java.util.Vector;

public class Consumer extends Thread {
	
	public Vector<Integer> count;
	
	@Override
	public synchronized void run() {
		while(count.isEmpty()) {}
		while(!count.isEmpty()) {
			System.out.println(Thread.currentThread().getName() + " is consuming " + this.decrement());
			try {
				Thread.sleep(50);
			}catch(InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	public Consumer(Vector<Integer> i) {
		this.count = i;
	}
	
	public synchronized int decrement() {
		return count.remove(0);
//		count.remove(0);
//		return i;
	}

}
