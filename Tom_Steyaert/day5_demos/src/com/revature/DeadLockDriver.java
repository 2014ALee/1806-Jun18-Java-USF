package com.revature;

import com.revature.models.Philosopher;

public class DeadLockDriver {

	public static void main(String[] args) {
		
	//	Date myDate = new Date(System.currentTimeMillis());
		//System.out.println(myDate);
		
		
		Philosopher[] philosophers = new Philosopher[5];
		Object[] forks = new Object[philosophers.length];
		
		for(int i = 0; i < forks.length; i++) {
			forks[i] = new Object();
		}
		
		for(int j = 0; j < philosophers.length ; j++) {
			Object leftFork = forks[j];
			Object rightFork = forks[(j + 1) % forks.length];
		
		if(j == philosophers.length-1) {
			philosophers[j] = new Philosopher(rightFork, leftFork);
		} else {
			philosophers[j] = new Philosopher(leftFork, rightFork);
			
		}
			
		//philosophers[j] = new Philosopher(leftFork, rightFork);
			
		Thread t = new Thread(philosophers[j], "Philosopher " + (j+1));	
		t.start();
		
		}
		
		System.out.println("---------------------------------------------------------------");
		
		Runnable r = () ->{
	for(int i = 0 ; i < 15; i++) {
		System.out.println(i);
	}
		};
		
		//synchronized blocks only allow one thread to access them
		
		
		Thread t = new Thread(r);
		
	}
	
}
