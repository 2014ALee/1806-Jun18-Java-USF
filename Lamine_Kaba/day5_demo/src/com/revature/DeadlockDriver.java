package com.revature;

import com.revature.models.Philosopher;

public class DeadlockDriver {
	
	public static void main(String[] args) {
		
		Philosopher[] philosophers = new Philosopher[5];
		Object[] forks = new Object[philosophers.length];

		for(int i = 0; i<forks.length; i++) {
			forks[i] = new Object();
			}

		for(int j = 0; j < philosophers.length; j++) {
			Object leftFork = forks[j];
			Object rightFork = forks[(j + 1) % forks.length];

			if(j == philosophers.length -1) {
				philosophers[j] = new Philosopher(leftFork, rightFork);
			}
			else {
				philosophers[j] = new Philosopher(rightFork, leftFork);
			}

			Thread t = new Thread(philosophers[j], "Philosopher " + (j+1));
			t.start();
		}

		System.out.println("+------------------------------------------------+");

		Runnable r = () ->{
			System.out.println("Hi, I'm a lambda expression");
		};

		Thread t = new Thread(r);
		t.start();
		
	}
}


