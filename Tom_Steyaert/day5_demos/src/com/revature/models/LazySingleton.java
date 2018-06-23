package com.revature.models;

/*
 * implemented by creating a class with a method that creates a new instance of the object if an instance doesn't already exist.
 * if it already exists we return a reference to it
 * 
 * to make sure we can't instantiate it in any other way, the constructor is made
 * private
 * 
 * although a singleton can be implemented as static
 * it can also be lazily constructed, requiring no memory
 * or resources until needed
 * 
 */

public class LazySingleton {

	
	private int value;
	
	
	//a static member of type lazysingleton will hold our one and only instance
	
	
	//it's lazy since it doesn't initially have an instance here
	private static LazySingleton mySingleton; 
	
	
	//making the constructor private ensures we can't call it from outside of the class
	private LazySingleton() {
		
	}
	
	
	//fetch our one and only instance
	public static LazySingleton getInstance() {
		
		return (mySingleton == null) ? mySingleton = new LazySingleton() : mySingleton;  
		
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue (int num){
		this.value = num;
	}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
}
