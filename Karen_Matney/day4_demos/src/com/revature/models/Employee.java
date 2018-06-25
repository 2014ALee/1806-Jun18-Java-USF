package com.revature.models;

public class Employee extends Thread {
	@Override
	public void run() { // logic. start() tells the thread to begin the work
		for(int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " is working....");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				/*
				 * InterruptedException is thrown when the Employee's interrupt()
				 * method is...ADD LATER
				 */
				e.printStackTrace();
			}
		}
	}
}
