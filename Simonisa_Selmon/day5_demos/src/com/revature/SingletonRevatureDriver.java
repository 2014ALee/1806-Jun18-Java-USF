package com.revature;
import com.revature.models.LazySingleton;

public class SingletonRevatureDriver {
	
	public static void main(String[] args) {
		
		LazySingleton ex1_2 = LazySingleton.getInstance();
		LazySingleton ex1_3 = LazySingleton.getInstance();
		
		System.out.println("ex1_2 ==ex1_3 : " +(ex1_2 == ex1_3));
		System.out.println("ex1_2 ==ex1_3 : " +(ex1_2.getValue()));
		System.out.println("ex1_2 ==ex1_3 : " +(ex1_3.getValue()));
		
ex1_2
		
		
		
		
		System.out.println("ex2_2 ==ex2_3 : " +(ex1_2 == ex1_3));
		System.out.println("ex2_2 ==ex1_3 : " +(ex1_2.getValue()));
		System.out.println("ex2_2 ==ex1_3 : " +(ex1_3.getValue()));
		
		

	}
}
