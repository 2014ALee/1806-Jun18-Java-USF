package com.revature;

public class GarbageDriver {
	public static void main(String[] args) {
		System.out.println("Instantiating a new GarbageDriver object...");
		GarbageDriver garbage = new GarbageDriver();
		System.out.println("GarbageDriver object successfully created!");

		System.out.println("Some time passes..");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		// Point is original GarbageDriver has nothing pointing to it, could be new GarbageDriver instead of null
		System.out.println("assign the variable 'garbage' to null");
		garbage = null;

		// SUGGESTS, it doesn't have to.
		System.gc();

		for(;;) {
			System.out.println("...");
		}
	}

	@Override
	protected void finalize() {
		System.out.println("GarbageDriver's finalize() method calledd!");
		System.out.println("Goodbye, cruel world!");
		System.exit(0);
	}
}