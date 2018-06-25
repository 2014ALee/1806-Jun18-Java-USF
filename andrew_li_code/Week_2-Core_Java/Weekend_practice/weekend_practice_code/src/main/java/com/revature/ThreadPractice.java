package com.revature;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.revature.models.Consumer;
import com.revature.models.Producer;

public class ThreadPractice {
	public static void main(String[] args) {
		ConcurrentLinkedQueue<Integer> lq = new ConcurrentLinkedQueue<Integer>();
		lq.add(1240);
		lq.add(1641);
		lq.add(12552);
		lq.add(2921);
		lq.add(7542);
		System.out.println("Running");
		Consumer consumer = new Consumer(lq);
		Producer producer = new Producer(lq);
		producer.start();
		consumer.start();
	}
}
