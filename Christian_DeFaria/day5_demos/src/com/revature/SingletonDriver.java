package com.revature;

import com.revature.models.EagerSingleton;
import com.revature.models.LazySingleton;

public class SingletonDriver {
	
	public static void main(String[] args) {
		
//		LazySingleton ex1_1 = new LazySingleton();
		LazySingleton ex1_2 = LazySingleton.getInstance();
		LazySingleton ex1_3 = LazySingleton.getInstance();
		System.out.println("ex1_2 == ex1_3?: " + (ex1_2 == ex1_3));
		System.out.println("ex1_2.getValue() = " + ex1_2.getValue()); //0
		System.out.println("ex1_3.getValue() = " + ex1_3.getValue()); //0
		
		ex1_2.setValue(10);
		System.out.println("ex1_2.getValue() = " + ex1_2.getValue()); //10
		System.out.println("ex1_3.getValue() = " + ex1_3.getValue()); //10
		
		System.out.println("---------------------------------------------");
		
		//Eager Instantiated singleton
//		EagerSingleton ex2_1 = new EagerSingeton();
		EagerSingleton ex2_2 = EagerSingleton.getInstance();
		EagerSingleton ex2_3 = EagerSingleton.getInstance();
		System.out.println("ex2_2 == ex1_3?: " + (ex2_2 == ex2_3));
		System.out.println("ex2_2.getValue() = " + ex2_2.getValue()); //0
		System.out.println("ex2_3.getValue() = " + ex2_3.getValue()); //0
		
		ex2_2.setValue(1000);
		System.out.println("ex2_2.getValue() = " + ex2_2.getValue()); //1000
		System.out.println("ex2_3.getValue() = " + ex2_3.getValue()); //1000
		
		try {
			EagerSingleton ex2_4 = (EagerSingleton) ex2_2.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
