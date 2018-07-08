package com.revature.models;

public class Employee extends Thread {

	@Override
	public void run() {
		
		
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " is working...");
			
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				e.printStackTrace();
				break;
			}
		}
		
	}
}
