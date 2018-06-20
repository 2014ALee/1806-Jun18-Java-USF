package com.revature;

public class GarbageDriver {

	public static void main(String[] args) {
		
		System.out.println("Putting a new garbageDriver object...");
		
	GarbageDriver garbage = new GarbageDriver();
	System.out.println("GarbageDriver object successfully created");
	
	System.out.println("Same timeperson...");
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException ie) {
		ie.printStackTrace();
	}
	System.out.println("Assign that variable 'garbage' to null");
	 garbage = null;
	 
	 System.gc();
	 
	 for(;;) {
		 System.out.println("....");
		 
	 }
	
	

	}
	protected void finalize() {
		System.out.println("garbage finalize");
		System.out.println("Gooobye cruel world");
		//System.exit(0);
	}
}
