package com.revature.models;

public class LazySingleton {

	//here to show that changes to one reference to our LazySingleton instance are persisted across all references
	private int value;

	//a static member of type LazySingleton will hold our one and only instance.  it starts of uninstantiated until we need to load it (lazy loading)
	private static LazySingleton mySingleton;

	//private constructor ensures that it cannot be called outside of this class
	private LazySingleton() {}

	//this public getter is used to fetch our once and only instance
	public static LazySingleton getInstance() {

		//this checks to see if you already have instance, if not that create it, otherwise just return it
		return (mySingleton == null) ? mySingleton = new  LazySingleton() : mySingleton;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int num) {
		this.value = num;
	}
	
	//override clone method to throw exception if invoked, otherwise this method could make a copy of our singleton which defeats the purpose
	@Override
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
}
