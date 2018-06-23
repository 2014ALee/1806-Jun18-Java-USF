package com.revature.models;

import java.sql.Date;

public class Philosopher implements Runnable {

	private Object leftFork;
	private Object righFork;
	
	public Philosopher(Object leftFork, Object rightFork) {
		this.leftFork = leftFork;
		this.righFork = rightFork;
	}
	
	private void doAction(String action) {
		System.out.println(Thread.currentThread().getName() + " " + action);
		try {
			Thread.sleep((long)(Math.random() * 1000));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep((long) Math.random() *100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String currentTime() {
		return new Date(System.currentTimeMillis()).toString().substring(11,19);
	}
	
	/*
	 * 
	 */
	
	@Override
	public void run() {
		
		while(true) {
			doAction(currentTime() + ": Contemplating the meaning of existence");
			
			synchronized(righFork) {
				doAction(currentTime() + ": Picked up right fork");
				
				synchronized(leftFork) {
					doAction(currentTime() + ": Picked up left fork - eating");
					doAction(currentTime() + ": put down left fork");
				}
				doAction(currentTime() + ": Put down right fork - thinking some more");
				return;
			}
		}
	}

	
}
