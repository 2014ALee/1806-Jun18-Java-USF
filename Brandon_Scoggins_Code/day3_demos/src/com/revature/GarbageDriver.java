package com.revature;

public class GarbageDriver {

	public static void main(String[] args) {
		System.out.println("Instantiating a new GarbageDrive object...");
		GarbageDriver garbage = new GarbageDriver();
		System.out.println("GarbageDriver object successfully created.");
		
		System.out.println("Some time passes...");
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
//		System.out.println("Assign variable garbage to null");
//		garbage = null;
		
		System.out.println("Assign variable garbage to some other GarbageDriver object");
		garbage = new GarbageDriver();
		
		// suggest to the JVM that garbage collection should be run
		System.gc();
		
		for(int i = 0;;i++) {
			System.out.println(i);
		}

	}
	
	@Override
	protected void finalize() {
		System.out.println("GarbageDriver finalize() method call.\nGoodbye cruel world.");
		System.exit(0);
	}
}
