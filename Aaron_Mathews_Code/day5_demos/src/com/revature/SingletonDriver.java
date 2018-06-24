package com.revature;

import com.revature.models.LazySingleton;

public class SingletonDriver {
	public static void main(String[] args) {
		System.out.println("--------------------------------");
		System.out.println("Singleton Design Patterns");
		
		//Lazily Instantiated Singleton
		//LazySingleton ex1_1 = new LazySingleton(); Doesnt work because constructor is private
		
		LazySingleton ex1_2 = LazySingleton.getInstance();
		LazySingleton ex1_3 = LazySingleton.getInstance();
		
		System.out.println("ex1_2 == ex1_3? : " + (ex1_2 == ex1_3));
		
		ex1_2.setValue(10);
		System.out.println("1_3 value changed to: " + ex1_3.getValue());
	}
}
