package com.revature;

public class GarbageDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Instantiating a new GarbageDriver object...");
		GarbageDriver garbage = new GarbageDriver();
		System.out.println("GarbageDriver object successfully created!");
		
		System.out.println("Sometime passes...");
		
		try {
			Thread.sleep(5000);
		}catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println("Assign the variable 'garbage' to null");
		garbage = null;//after this line the new garbageDriver object that was created is unreferenced, so the garbage
						//collector may delete the unreferenced object. JVM determines when the garbage collector is used
						
		
		System.gc();
		
	
		for(;;) {
			System.out.println("...");
		
			
		}

			
		}
	
	@Override
	protected void finalize() {
		System.out.println("GarbageDriver's finalize() method called!");
		System.out.println("Goodbye, cruel world!");
		System.exit(0);

	}

}
