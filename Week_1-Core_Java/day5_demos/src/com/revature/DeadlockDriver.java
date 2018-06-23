package com.revature;

import com.revature.models.Philosopher;

/*
 *The Dining Philosophers problem is one of the classic problems used
 * to describe synchronization issues in a multithreaded environment
 * and illustrate techniques for solving them.
 *
 * There are five silent philosophers (P1 – P5) sitting around a circular
 * table, spending their lives eating and thinking.
 *
 * There are five forks for them to share (1 – 5) and to be able to eat,
 * a philosopher needs to have forks in both his hands. After eating, he
 * puts both of them down and then they can be picked by another philosopher
 * who repeats the same cycle.
 *
 * The goal is to come up with a protocol that helps the philosophers achieve
 * their goal of eating and thinking without starving to death (which will happen
 * if they deadlock).
 */
public class DeadlockDriver {

	public static void main(String[] args) {

		// Use a Date object to format System time into something more legible
//		Date myDate = new Date(System.currentTimeMillis());
//		System.out.println(myDate);
		
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
			
			Thread t = new Thread(philosophers[j], "Philosopher " + (j + 1));
			t.start();
		}
		
		System.out.println("+---------------------------------------------------------------+");
		
		Runnable r = () -> {
			for(int i = 0; i < 15; i++) {
				System.out.println("i: " + i);
			}
		};
		
		Thread t = new Thread(r);
		t.start();
	}
}
