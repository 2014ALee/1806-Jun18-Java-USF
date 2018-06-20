package com.revature;

public class GarbageDriver {

	public static void main(String[] args) {
		
		System.out.println("instantiating a new GarbageDriver object...");
		GarbageDriver garbage = new GarbageDriver();
		System.out.println("GarbageDriver object successfully created!");
		
		System.out.println("Some time passes...");
		try {
			Thread.sleep(1000);
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println("Assign the variable 'garbage' to null");
		garbage = null;  //now this object is eligible for garbage collection because it has no references
		
		System.gc(); //suggests the garbage collector to run through and clean up
		
		for(;;)
		{
			//the finalize method will be called by the garbage collector on the background thread while this infinite loop runs
		System.out.println("...........");
		}
	}
	
	@Override
	protected void finalize() {
		System.out.println("GarbageDriver's finalize() method called!"); //this will tell us if the garbage collector came through because this method is called right before it gets garbage collected
		System.exit(0); //this is just to end the program and it will break the infinite loop
	}
}
