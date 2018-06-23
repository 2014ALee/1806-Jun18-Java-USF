package com.revature.models;

import java.util.Date;

public class Philosopher implements Runnable{

	private Object leftFork;
	private Object rightFork;
	
	public Philosopher(Object leftFork, Object rightFork) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}
	
	private void doAction(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep ((int)(Math.random() * 1000));
		
	}
	
	private String currentTime() {
		return new Date(System.currentTimeMillis()).toString().substring(11, 19);
	}
	
	
	@Override
	public void run() {

		try {
			
			while(true) {
				doAction(currentTime() + ": Contemplating");
				
				synchronized(rightFork) {
					doAction(currentTime() + ": picked up right fork");
					
					synchronized(leftFork) {
						doAction(currentTime() + ": picked up left fork - eating");
						doAction(currentTime() + ": put down left fork");
					}
					doAction(currentTime() + ": put down right fork - thinking");
					return;
				}
				
			}
			
		} catch (InterruptedException e){
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
		
	}

	
	
	
	
	
	
}
