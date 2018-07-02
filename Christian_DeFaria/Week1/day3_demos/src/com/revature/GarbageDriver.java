package com.revature;

public class GarbageDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Instaniating a new GarbageDriver object...");
		GarbageDriver garbage = new GarbageDriver();
		System.out.println("GarbgeDriver object has been successfully created!");
		
		System.out.println("Some time passes");
		
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Assign the variable 'garbage' to null");
		garbage = null;
		
		System.gc();		//asks garbage collection to run
		
		for(;;) {
			System.out.println("...");
		}
	}
	
	@Override
	protected void finalize() {
		System.out.println("GarbageDriver's finalize method called!");
		System.out.println("Goodbye cruel world!");
		System.exit(0);
	}

}
