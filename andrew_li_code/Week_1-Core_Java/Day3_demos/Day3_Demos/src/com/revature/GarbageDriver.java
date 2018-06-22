package com.revature;

public class GarbageDriver {
	public static void main(String[] args) {
		System.out.println("Instantiating a new GarbageDriver object...");
		GarbageDriver garbage = new GarbageDriver();
		System.out.println("GarbageDriver object created!!!");
		
		System.out.println("Some time passes...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
;		
		System.out.println("Assign the variable \"garbage\" to null.");
		garbage = new GarbageDriver();
		
		for (int i = 1 ;; i++) {
			System.out.println("Still waiting at iteration " + i + "...");
		}
	}
	@Override
	protected void finalize() {
		System.out.println("Garbage has been collected.");
		System.out.println("Goodbye, use my memory space well!");
		System.exit(0);
	}
}
