package com.revature.models;

public class Employee extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " is working");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				System.out.println("Don't interrupt me! I'm working");
				ie.printStackTrace();
				break;
			}
		}
	}

}
