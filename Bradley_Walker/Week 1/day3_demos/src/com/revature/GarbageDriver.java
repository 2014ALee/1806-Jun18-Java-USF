package com.revature;

public class GarbageDriver {

	public static void main(String[] args) {
		System.out.println("Instantiating a new GarbageDriver object...");
		GarbageDriver garbage = new GarbageDriver();
		System.out.println("GarbageDriver created");
		
		System.out.println("Wait for it...");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Assign the variable 'gd' to null");
		garbage = null;
		
		System.out.println("Requesting garbage collection");
		System.gc();
	}

	@Override
	protected void finalize() {
		System.out.println("I see the light");
		System.exit(0);
	}
}
