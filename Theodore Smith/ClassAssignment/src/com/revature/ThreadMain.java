package com.revature;

public class ThreadMain {
	
	// Manually making it thread safe using a vector because you do not need to use one.
	public static void main(String[] args) throws InterruptedException {
		
		final Producer p = new Producer();
		
		// Created the run were we create usual programs we use do not do that.
		Thread r1 = new Thread(new Runnable() {
			
			public void run(){
				try{
					p.Producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			
		}
		});
		
		Thread r2 = new Thread(new Runnable() {
			
			public void run(){
				try{
					p.Consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				
			
		});
		
		r1.start();
		r2.start();
		
		
		r1.join();
		r2.join();
		
	}
	
		


}
