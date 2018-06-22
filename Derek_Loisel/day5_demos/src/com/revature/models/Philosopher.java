package com.revature.models;

import java.util.Date;

public class Philosopher implements Runnable{

	//the forks are the resources our threads are going to be using
	private Object leftFork;
	private Object rightFork;
	
	public Philosopher(Object leftFork, Object rightFork) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}
	
	//simulate an action
	private void doAction(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep((long) (Math.random() * 1000));
	}
	
	private String currentTime() {
		return new Date(System.currentTimeMillis()).toString().substring(11, 19);
	}
	@Override
	public void run() {
		
		//we know we're going to be calling do action with an interrupted exception so its going in a try catch
		try {
			
			while(true)
			{
				doAction(currentTime() + ": Contemplating the meaning of existence");
				
				synchronized(rightFork) {
					doAction(currentTime() + ": Picked up right fork");
					
					synchronized(leftFork) {
						doAction(currentTime() + ": Picked up left fork - eating");
						doAction(currentTime() + ": Put down left fork");
					}
					
					doAction(currentTime() + ": Put down right fork - thinking some more");
					return;
				}
			}
		}catch(InterruptedException ie) {
			
		}
	}

	//the philosophers are the threads
}
