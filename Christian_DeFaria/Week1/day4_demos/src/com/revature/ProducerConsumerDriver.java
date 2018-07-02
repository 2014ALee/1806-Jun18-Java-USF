package com.revature;

import java.util.Vector;

import com.revature.models.Consumer;
import com.revature.models.Producer;

public class ProducerConsumerDriver {
	
	public static Vector<Integer> count = new Vector<>();
//	public final int BOUNDS = 5;
	
	public static void main(String[] args) {
		Producer p = new Producer(count);
		Consumer c1 = new Consumer(count);
		Consumer c2 = new Consumer(count);
		
		p.start();
		try {
			Thread.sleep(50);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		c1.start();
		c2.start();
		
		try {
			p.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
//		while(!count.isEmpty()) {	}
	}

}
