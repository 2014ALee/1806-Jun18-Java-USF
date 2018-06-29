package com.revature;

import com.revature.models.EagerSingleton;
import com.revature.models.LazySingleton;

public class SingletonDriver {

	//singleton ensures that only one instance of an object is created, but you need to override the clone method
	
	//lazy loading means you dont want to create the object until you need it
	//eager loading means you make it right away
	
	public static void main(String[] args) {

		//lazily-instantiated singleton
		//LazySingleton ex1_1 = new LazySingleton(); //doesnt work because constructor is private
		LazySingleton ex1_2 = LazySingleton.getInstance();
		LazySingleton ex1_3 = LazySingleton.getInstance();
		
		System.out.println("ex1_2 == ex1_3? : " + (ex1_2 == ex1_3)); true
		
		System.out.println("------------------------------------------");
		
		EagerSingleton ex2_2 = EagerSingleton.getInstance();
		EagerSingleton ex2_3 = EagerSingleton.getInstance();
		
		System.out.println(ex2_2 == ex2_3); //true
		
		System.out.println(ex2_3.getValue()); //0
		ex2_2.setValue(1000);
		System.out.println(ex2_3.getValue()); //1000
	}
}
