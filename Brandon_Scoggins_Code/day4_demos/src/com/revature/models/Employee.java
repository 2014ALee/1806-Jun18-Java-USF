package com.revature.models;

public class Employee extends Thread {

	@Override
	public void run() {			// defines the logic to be executed by the thread
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " is working...");
			
			try {
				Thread.sleep(2000);
			}catch(InterruptedException ie) {
				/*
				 * InterruptedException is thrown when the Emplyee's interrupt()
				 * method is called. 
				 */
				ie.printStackTrace();
				break;
			}
		}
	}
}
