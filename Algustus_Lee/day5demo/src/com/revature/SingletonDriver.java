package com.revature;

import com.revature.models.EagerSingleton;
import com.revature.models.LazySingleton;

public class SingletonDriver {
	public static void main(String[] args) {
		System.out.println("+-------------------------------------------------------+");
		System.out.println("                          Singleton design patterns");
		
		//Lazily-instantiated Singleton
		//LazySingleton ex1_1 = new LazySingleton(); The constructor is private, so this doesn't work!
		
		LazySingleton ex1_2 = LazySingleton.getInstance();
		LazySingleton ex1_3 = LazySingleton.getInstance();
		
		System.out.println("ex1_2 == ex1_3? :"+ (ex1_2 == ex1_3)); //proof that examples 2 and three get the same instance
		System.out.println("ex1_2.getValue" + ex1_2.getValue()); //prints 0
		System.out.println("ex1_3.getValue" + ex1_3.getValue()); //prints 0
		
		ex1_2.setValue(10);
		System.out.println("ex1_2.getValue" + ex1_2.getValue());
		System.out.println("ex1_3.getValue" + ex1_3.getValue());
		
		//Eagerly-instantiated Singleton
		//EagerSingleton ex2_1 = new EagerSingleton(); //Still doesn't work, the constructor is private!
		
		EagerSingleton ex2_2 = EagerSingleton.getInstance();
		EagerSingleton ex2_3 = EagerSingleton.getInstance();
		
		System.out.println("ex2_2 == ex2_3?: "+(ex2_2 == ex2_3));
		System.out.println("ex2_2.getValue(): "+ex2_2.getValue());
		System.out.println("ex2_3.getValue(): "+ex2_3.getValue());
		
		ex2_2.setValue(1000);
		System.out.println("ex2_2.getValue(): "+ex2_2.getValue());
		System.out.println("ex2_3.getValue(): "+ex2_3.getValue());
		
		try {
			EagerSingleton ex2_4 = (EagerSingleton) ex2_2.clone();
		} catch (CloneNotSupportedException e) {
			// override the clone exception to prevent singletons from being cloned.
			e.printStackTrace();
		}
	}

}
