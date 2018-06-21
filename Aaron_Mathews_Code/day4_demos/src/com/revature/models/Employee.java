package com.revature.models;

public class Employee extends Thread {
	
	/*
	 * Run() defines the executions. Doesn't create a new thread. Is ran by the thread that called it
	 * Start() just tells the thread to run. Creates a new thread
	 */

	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " is working.");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
				/*
				 * InterruptedException is thrown when the employee's interrupt method
				 * is called.
				 */
				break;
			}
		}
		
	}
}
