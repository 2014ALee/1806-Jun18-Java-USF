package com.revature;

import com.revature.models.EagerSingleton;
import com.revature.models.LazySingleton;

public class SingletonDriver {

	//lazy and eager loading
	//thread safe and not thread safe
	
	public static void main(String[] args) {
		System.out.println("--------------------------------------------------");
		System.out.println("         SINGLETON DESIGN PATTERN");
		
		//LAZY ONE
		//LazySingleton ex1_1 = new LazySingleton();
		
		LazySingleton ex1_2 = LazySingleton.getInstance();
		LazySingleton ex1_3 = LazySingleton.getInstance();
		
		ex1_2.setValue(52);
		System.out.println(ex1_3.getValue());
		System.out.println(ex1_2.getValue());

		EagerSingleton eager1;
		EagerSingleton eager2;
	
	}
}
