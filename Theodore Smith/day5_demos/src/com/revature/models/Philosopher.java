package com.revature.models;

import java.util.Date;

public class Philosopher  implements Runnable {
	
	private Object leftFork;
	private Object rightFork;
	
	public Philosopher(Object leftFork, Object rightFork) {
		
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}
		private void doAction(String action) {
			System.out.println(Thread.currentThread().getName() + "" + action);
			Thread.sleep((long) (Math.random() * 100);
		}
		
		private String currentTime() {
			
			return new Date(System.currentTimeMillis()).toString().substring(11,19);
		}
		
		public void run() {
			
			
			try {
				while(true) {
					doAction(currentTime() + ": Contemplating the meaning of existance";)
					
					
				}
			}
		}
}
