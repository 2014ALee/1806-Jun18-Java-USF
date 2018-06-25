package com.revature;

import java.util.Date;

import com.revature.models.Philosopher;

/*
 * The Dining Philosophers problem is one of the classic problems used
 * to describe synchronization issues in a multi-threaded enviornment
 * and illustrate techniques for solving them.
 * 
 * There are five silent philosophers (P1-P5) and to 
 */
public class DeadlockDriver {
	public static void main(String[] args) {
//		Philosopher[] philosophers = new Philosopher[5];
//		Object[] forks = new Object[philosophers.length];
//		
//		for(int i = 0; i < forks.length; i++) {
//			forks[i] = new Object();
//		}
//		
//		for(int j = 0; j < philosophers.length; j++) {
//			Object leftFork = forks[j];
//			Object rightFork = forks[(j + 1) % forks.length];
//			
//			if(j == philosophers.length - 1) {
//				philosophers[j] = new Philosopher(rightFork, leftFork);
//			} else {
//				philosophers[j] = new Philosopher(leftFork,rightFork);
//			}
//			
////			philosophers[j] = new Philosopher(leftFork,rightFork);
//			
//			Thread t = new Thread(philosophers[j], "Philosopher " + (j +1));
//			t.start();
			
			
			System.out.println("+--------------------------------------+");
			
			// If interface, but have only one abstract method (a Functional Interface)
			Runnable r = () -> {
				System.out.println("Hi, I'm a lambda expression!");
			};
			Thread t = new Thread(r);
			t.start();
		}
	//}
}
