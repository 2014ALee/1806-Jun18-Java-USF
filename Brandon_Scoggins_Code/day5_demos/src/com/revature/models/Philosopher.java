package com.revature.models;

import java.util.Date;

public class Philosopher implements Runnable {

	private Object leftFork;
	private Object rightFork;
	
	public Philosopher (Object leftFork, Object rightFork) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}
	
	private void doAction(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep((long)(Math.random() * 1000));
	}
	
	private String currentTime() {
		return new Date(System.currentTimeMillis()).toString().substring(11, 19);
	}
	
	/*
	 * 
	 */
	
	@Override
	public void run() {
		try {
			while(true) {
				doAction(currentTime() + ": Contemplating meaning of existence.");
				
				synchronized (rightFork) {
					doAction(currentTime() + ": Picked up right fork.");
					
					synchronized (leftFork) {
						doAction(currentTime() + ": Picked up left fork. Eating...");
						doAction(currentTime() + ": Put down left fork.");
					}
					
					doAction(currentTime() + ": Put down right fork. Thinking again...");
				}
				return;
			}
		}catch(InterruptedException ie) {
			Thread.currentThread().interrupt();
			ie.printStackTrace();
		}
	}

}
