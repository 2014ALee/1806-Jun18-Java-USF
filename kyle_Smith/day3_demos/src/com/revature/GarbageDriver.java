package com.revature;

public class GarbageDriver {

	public static void main(String[] args) {
		
		System.out.println("Instantiating a new GarbageDriver object...");
		GarbageDriver garbage = new GarbageDriver();
		System.out.println("GarbageDriver object successfully created!");
		
		System.out.println("Some time Passes...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println("Assign the variable 'garbage' to null");
		garbage = null;
		
		System.gc();
		
		for(;;) {
			
		}
		
		
	}
	@Override
	protected void finalize() {
		System.out.println("GarbageDriver's finalize() method called!");
		System.out.println("Goodbye, cruel world!");
	}
}
