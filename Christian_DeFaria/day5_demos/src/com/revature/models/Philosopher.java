package com.revature.models;

import java.util.Date;
import java.time.LocalTime;

public class Philosopher implements Runnable {
	
	private Object leftFork;
	private Object rightFork;
	
	public Philosopher(Object lf, Object rf) {
		this.leftFork = lf;
		this.rightFork = rf;
	}
	
	private void doAction(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep((long) (Math.random() * 1000));
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
				doAction(currentTime() + ": contemplating the meaning of existance");
				
				synchronized (rightFork) {
					doAction(currentTime() + ": picked up right fork");
					
					synchronized (leftFork) {
						doAction(currentTime() + ": picked up right fork - eating");
						doAction(currentTime() + ": put down left fork");
					}
					doAction(currentTime() + ": put down right fork - thinking some more");
					return;
				}
			}
			
		} catch(InterruptedException e) {
			Thread.currentThread();
			e.printStackTrace();
		}
		
	}
	
	

}
