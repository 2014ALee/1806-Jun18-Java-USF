package com.revature;

import com.revature.models.EagerSingleton;
import com.revature.models.LazySingleton;

public class SingletonDriver {

	//lazy loading (thread safe) /eager loading (not thread safe)
	public static void main(String[] args) {
		System.out.println("--------------------------------------------------------");
		System.out.println("               SINGLETON DESIGN PATTERNS");
		System.out.println("--------------------------------------------------------");
		
		//lazily-instantiated singleton
//		LazySingleton ex1_1 = new LazySingleton();// does not work, becuase the constructor is private!
		
		LazySingleton ex1_2 = LazySingleton.getInstance();
		LazySingleton ex1_3 = LazySingleton.getInstance();
		
		System.out.println("ex1_2 == ex1_3? : " + (ex1_2 == ex1_3));
		
		ex1_2.setValue(10);
		System.out.println(ex1_2.getValue());
		System.out.println(ex1_3.getValue());
		
		//EAGER-INSTANTIATED SINGLETON
//		EagerSingleton ex2_1 = new EagerSingleton(); //does not work, constructor is private
		
		EagerSingleton ex2_2 = EagerSingleton.getInstance();
		EagerSingleton ex2_3 = EagerSingleton.getInstance();
		

		System.out.println("ex2_2 == ex2_3? : " + (ex2_2 == ex2_3));
		
		ex2_2.setValue(10);
		System.out.println(ex2_2.getValue());
		System.out.println(ex2_3.getValue());
		
		try {
			EagerSingleton ex2_4 = (EagerSingleton) ex2_2.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
