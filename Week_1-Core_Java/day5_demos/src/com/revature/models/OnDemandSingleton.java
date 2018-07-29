package com.revature.models;

/*
 * This idiom derives its thread safety from the fact that operations that are 
 * part of class initialization, which is guaranteed by the JVM. It derives its 
 * lazy initialization from the fact that the inner class is not loaded until 
 * some thread references one of its fields or methods. Since this implementation
 * is based upon the class initialization procedure, it is guaranteed by Java
 * to be thread-safe.
 */
public class OnDemandSingleton {
	
	private int value;
	
	/*
	 * A nested private static class that contains an instantiated reference to
	 * a OnDemandSingleton object. Since this inner class is required to be static,
	 * otherwise we cannot declare our 'mySingleton' member as static.
	 */
	private static class SingletonHolder {
		
		/*
		 * This is the instantiated object that will serve as our one and only
		 * instance of the OnDemandSingleton class.
		 */
		public static OnDemandSingleton mySingleton = new OnDemandSingleton();
	}
	
	/*
	 * Making the constructor of our outer class private ensures that it cannot
	 * be called outside of the class itself.
	 */
	private OnDemandSingleton() { }
	
	/*
	 * This public getter method is what is used to fetch the our only
	 * instance of the OnDemandSingleton class.
	 */
	public static OnDemandSingleton getInstance() {
		return SingletonHolder.mySingleton;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
