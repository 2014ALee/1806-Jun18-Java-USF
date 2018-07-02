package com.revature.models;

import java.util.Vector;

public class Producer extends Thread {
	
	public Vector<Integer> count;
	private int products = 10;
	
	@Override
	public synchronized void run() {
		for(int i = 0; i<products; i++) {
			System.out.println(Thread.currentThread().getName() + " is producing " + i);
			this.increment(i);
//			try {
//				Thread.sleep(1000);
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//				break;
//			}
		}
	}
	
	public Producer(Vector<Integer> i) {
		this.count = i;
	}
	
	public synchronized void increment(int i) {
		count.addElement(new Integer(i));;
	}

}
