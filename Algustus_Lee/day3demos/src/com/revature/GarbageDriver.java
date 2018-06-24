package com.revature;

public class GarbageDriver {
	public static void main(String[] args)
	{
		System.out.println("Instantiating a new GarbageDriver object.");
		
		GarbageDriver garbage = new GarbageDriver();
		System.out.println("GarbageDriver object successfully created.");
		
		System.out.println("Some time passes...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Assign the variable 'garbage' to another GarbageDriver object");
		garbage = new GarbageDriver();
		
		System.gc();
		
		for (;;) {
			
		}
	}
	@Override
	protected void finalize() {
		System.out.println("GarbageDriver's finalize method called!");
		System.out.println("I'm deleted.");
	}
}
