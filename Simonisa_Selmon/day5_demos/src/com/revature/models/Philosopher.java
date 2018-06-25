package com.revature.models;
import java.util.Date;

import Runnable;

public class Philosopher implements Runnable {
	
	private object leftfork;
	private object rightfork;
	
	public Philosopher(Object leftfork, Object rightfork) {
		this.leftfork= leftfork;
		this.rightfork= rightfork;
		
	}

	private void doAction(String action){
		System.out.println(Thread.currentThread().getName()) + " "+ action);	
		Thread.sleep((long) Math.random() * 100);
	}
	
	public void() {
		return new Date(); 
		
	}
	 public void run() {
	 
}
}