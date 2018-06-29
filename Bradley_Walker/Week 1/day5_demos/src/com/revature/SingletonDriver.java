package com.revature;

import com.revature.models.EagerSingleton;
import com.revature.models.LazySingleton;

public class SingletonDriver {

	public static void main(String[] args) {
		// lazy singleton
		LazySingleton ex1_1 = LazySingleton.getInstance();
		LazySingleton ex1_2 = LazySingleton.getInstance();
		
		System.out.println(ex1_1.getValue());
		System.out.println(ex1_2.getValue());
		ex1_1.setValue(9);
		System.out.println(ex1_1.getValue());
		System.out.println(ex1_2.getValue());
		
		System.out.println("------------------------------------");
		
		// eager singleton
//		EagerSingleton ex2_1 = new EagerSingleton()	// Doesn't work
		EagerSingleton ex2_2 = EagerSingleton.getInstance();
		EagerSingleton ex2_3 = EagerSingleton.getInstance();
		
		System.out.println(ex2_2.getValue());
		System.out.println(ex2_3.getValue());
		ex2_2.setValue(9);
		System.out.println(ex2_2.getValue());
		System.out.println(ex2_3.getValue());
	}

}
