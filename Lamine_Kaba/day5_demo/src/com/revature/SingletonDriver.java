package com.revature;

import com.revature.models.EagerSingleton;
import com.revature.models.LazySingleton;

public class SingletonDriver {

	public static void main(String[] args) {
		
		//LazySingleton ex_1 = new LazySingleton()  // does not work because the constructor is private
		
		LazySingleton ex_2 = LazySingleton.getInstance();
		LazySingleton ex_3 = LazySingleton.getInstance();
		
		System.out.println("ex2 == ex3? "  + (ex_2 == ex_3));
		
		System.out.println("ex2.getValue() = "  + (ex_2.getValue())); 
		System.out.println("ex3.getValue() = "  + (ex_3.getValue()));
		
		ex_2.setValue(10);
		//ex_3.setValue(10);  Changing for one will change both
		System.out.println("ex2.getValue() = "  + (ex_2.getValue())); 
		System.out.println("ex3.getValue() = "  + (ex_3.getValue()));
		
		
		System.out.println("----------------------------");
		
		EagerSingleton ex2 = EagerSingleton.getInstance();
		EagerSingleton ex3 = EagerSingleton.getInstance();
		
		System.out.println("ex2 == ex3? "  + (ex_2 == ex_3));
		
		System.out.println("ex2.getValue() = "  + (ex2.getValue())); 
		System.out.println("ex3.getValue() = "  + (ex3.getValue()));
		
		ex2.setValue(100);
		System.out.println("ex2.getValue() = "  + (ex2.getValue())); 
		System.out.println("ex3.getValue() = "  + (ex3.getValue()));

	}

}
