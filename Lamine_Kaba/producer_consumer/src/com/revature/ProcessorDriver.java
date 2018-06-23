package com.revature;

public class ProcessorDriver {

	public static void main(String[] args) {
		
		Processor myProcessor = new Processor();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					myProcessor.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					myProcessor.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		t1.start();
		t2.start();
	}

}
