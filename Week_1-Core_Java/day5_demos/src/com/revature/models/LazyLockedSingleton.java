package com.revature.models;

/*
 * The LazySingleton and EagerSingleton work absolutely fine in a single threaded environment 
 * and processes the result faster because of lazy initialization. However, 
 * the non-thread-safe examples might create some abrupt behavior in the results in a 
 * multithreaded environment as in this situation multiple threads can 
 * possibly create multiple instance of the same SingletonExample class if 
 * they try to access the getSingletonInstance() method at the same time.
 * 
 * In the multithreading environment to prevent each thread to create 
 * another instance of singleton object and thus creating concurrency issue 
 * we will need to use locking mechanism.
 */
public class LazyLockedSingleton {

	/*
	 * The setup of this type of singleton is nearly the same as our LazySingleton
	 * example. However, to ensure that our singleton design pattern works in a 
	 * multithreaded application we need to tweak our mySingleton static variable
	 * and the getInstance() method.
	 */
	private int value;

	/*
	 * The keyword 'volatile' has been added to the method signature to guarantee
	 * that this method is visible across all threads. It also helps to ensure that
	 * changes made in one thread are reflected across all threads.
	 */
	private static volatile LazyLockedSingleton mySingleton;

	private LazyLockedSingleton() { }

	/*
	 * We could add the 'synchronized' keyword to the method signature and prevent some 
	 * other thread from accessing the singleton instance while the initial thread is 
	 * inside the getInstance() method.
	 * 
	 * However, this adds a lot of additional overhead every time this method gets called.
	 * So, instead what we can do to prevent this extra work is to use double checked locking
	 * so that the synchronization only occurs during the first call.
	 */
	public static LazyLockedSingleton getInstance() {
		
		if (mySingleton == null) {
			synchronized(LazyLockedSingleton.class) {
				return (mySingleton == null) ? mySingleton = new LazyLockedSingleton() : mySingleton;
			}
		}
		
		return mySingleton;
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
