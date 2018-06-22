package com.revature;

import com.revature.models.Employee;

public class ThreadDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee(){
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					System.out.println("Employee 1");
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
		};
		Employee emp2 = new Employee(){
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					System.out.println("Employee 2");
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
		};
		emp1.start();
		emp2.start();
	}

}
