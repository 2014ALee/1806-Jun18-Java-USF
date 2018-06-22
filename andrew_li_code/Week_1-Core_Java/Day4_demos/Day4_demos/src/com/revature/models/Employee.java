package com.revature.models;

public class Employee extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep((int) (Math.random() * 200));
			} catch (InterruptedException e) {
				/*
				 * Interrupted Exception is thrown when the
				 * Employee's interrupt method is called.
				 * We will break out if it occurs.
				 */
				e.printStackTrace();
				break;
			}
		}
	}
}
