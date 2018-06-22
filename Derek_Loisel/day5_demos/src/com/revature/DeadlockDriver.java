package com.revature;

import java.util.Date;

import com.revature.models.Philosopher;

public class DeadlockDriver {

	
	public static void main(String[] args) {
		
//		Date myDate = new Date(System.currentTimeMillis());
//		

		Philosopher[] philosophers = new Philosopher [5];
		Object[] forks = new Object[philosophers.length];
		
		for (int i = 0; i< forks.length; i++) {
			forks[i] = new Object();
		}
		
		for (int j = 0; j < philosophers.length; j++) {
			Object leftFork = forks[j];
			//make sure fork is adjacent
			Object rightFork = forks[(j+1) % forks.length];
			
			
			//this has the first 4 pick up the right fork first and the last philosopher pick up the left fork first
			if (j == philosophers.length - 1)
			{
				philosophers[j] = new Philosopher(rightFork, leftFork);
			}else {
				philosophers[j] = new Philosopher(leftFork, rightFork);
			}
			
			
			Thread t = new Thread(philosophers[j], "Philosopher " + (j + 1));
			t.start();
		}
		
		//lambda expression
		
		//must use lambdas with functional interface only
		//might wanna use a lamda expression if you dont wanna reuse the code anywhere else and you just wanna use it in one spot, its like an object without a name
		Runnable r = () -> {
			for (int i = 0; i < 15; i++)
				System.out.println(i);
		};
		
		Thread t = new Thread(r);
		t.start();
		
		
	}
}
