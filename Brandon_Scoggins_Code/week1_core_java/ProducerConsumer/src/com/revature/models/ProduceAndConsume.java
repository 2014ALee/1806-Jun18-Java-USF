package com.revature.models;

import java.util.LinkedList;
import java.util.List;

public class ProduceAndConsume {

	static List<Integer> list = new LinkedList<>();
	static int maxLength = 50;

	public void produce() {
		int value = 0;

		while(true) {
			synchronized (this) {
				try {
					while(list.size() == maxLength) {
						wait();
					}
					System.out.println("Producer added " + value + " to the list.");
					list.add(value++);
					notify();

//					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void consume() {
		while(true) {
			synchronized (this) {
				try {
					while(list.size() == 0) {
						wait();
					}
					System.out.println("Consumer removed " + list.get(0) + " to the list.");
					list.remove(0);
					notify();

//					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
