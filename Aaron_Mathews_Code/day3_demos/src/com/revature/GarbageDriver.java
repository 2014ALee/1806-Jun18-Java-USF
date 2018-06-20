package com.revature;

public class GarbageDriver {
	
	public static void main(String[] args) {
		
		System.out.println("Instantiating a new garbage driver object.");
		
		GarbageDriver garbage = new GarbageDriver();
		System.out.println("GarbageDriver object succesfully created.");
		
		System.out.println("Some time passes...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			
		}
		System.out.println("Assign the variable 'garbage' to null.");
		garbage = null;
		
		//Cannot force garbage collection to happen.
		//Can suggest to jvm for gc to happen.
		
		System.gc();
		
		for(;;) {
			
		}
	}
	
	@Override
	protected void finalize() {
		System.out.println("GarbageDriver's finalize method called! \nGoodbye cruel world!");
	}

}
