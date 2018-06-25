package com.revature;

import com.revature.models.EagerSingleton;
import com.revature.models.LazySingleton;

public class SingletonDriver {

	public static void main(String[] args) {
		
		// Lazily-Instantiated Singleton
//		LazySingleton ex1_1 = new LazySingleton();			// does not work, because the constructor is private
		
		LazySingleton ex1_2 = LazySingleton.getInstance();
		LazySingleton ex1_3 = LazySingleton.getInstance();
		
		System.out.println("ex1_2 == ex1_3? : " + (ex1_2 == ex1_3));
		System.out.println("ex1_2.getValue() = " + ex1_2.getValue());
		System.out.println("ex1_3.getValue() = " + ex1_3.getValue());
		
		ex1_2.setValue(10);
		System.out.println("ex1_2.getValue() = " + ex1_2.getValue());
		System.out.println("ex1_3.getValue() = " + ex1_3.getValue());

		ex1_3.setValue(5);
		System.out.println("ex1_2.getValue() = " + ex1_2.getValue());
		System.out.println("ex1_3.getValue() = " + ex1_3.getValue());
		
		
		System.out.println("=======================================================");
		
		// Eager-Instantiated Singleton
//		EagerSingleton ex2_1 = new EagerSingleton();		// does not work, because the constructor is private
		
		EagerSingleton ex2_2 = EagerSingleton.getInstance();
		EagerSingleton ex2_3 = EagerSingleton.getInstance();

		System.out.println("ex2_2 == ex1_3? : " + (ex2_2 == ex2_3));
		System.out.println("ex2_2.getValue() = " + ex2_2.getValue());
		System.out.println("ex2_3.getValue() = " + ex2_3.getValue());
		
		ex2_2.setValue(10);
		System.out.println("ex2_2.getValue() = " + ex2_2.getValue());
		System.out.println("ex2_3.getValue() = " + ex2_3.getValue());

		ex2_3.setValue(5);
		System.out.println("ex2_2.getValue() = " + ex2_2.getValue());
		System.out.println("ex2_3.getValue() = " + ex2_3.getValue());
		
		
		
		try {
			EagerSingleton ex2_4 = (EagerSingleton) ex2_2.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
