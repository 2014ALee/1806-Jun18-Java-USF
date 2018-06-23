package com.revature;

import com.revature.models.Philosopher;

public class DeadlockDriver {
	
	public static void main(String[] args) {
//		Date myDate = new Date(System.currentTimeMillis());
//		System.out.println(myDate);
//		System.out.println(System.currentTimeMillis());
		
		Philosopher[] philosophers = new Philosopher[5];
		Object[] forks = new Object[philosophers.length];
		
		for(int i = 0; i < forks.length; i++) {
			forks[i] = new Object();
		}
		
		for (int j = 0; j < philosophers.length; j++) {
			Object leftFork = forks[j];
			Object rightFork = forks[(j + 1) % forks.length];
			
			if(j == philosophers.length - 1) {
				philosophers[j] = new Philosopher(rightFork, leftFork);
			} else {
				philosophers[j] = new Philosopher(leftFork, rightFork);
			}
			
//			philosophers[j] = new Philosopher(leftFork, rightFork);
			
			Thread t = new Thread(philosophers[j], "Philosopher " + (j+1));
			t.start();
		}
		System.out.println("----------------------------------------------------------");
		//impalment runnable to make threads
		//synchronized blocks restric access to one thread at a time
		//Lambda must be a functional interfaces (1 abstract method)
		Runnable r = () -> {
			for(int i = 0; i < 15; i++)	{
				System.out.println("i: " + i);
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
}
