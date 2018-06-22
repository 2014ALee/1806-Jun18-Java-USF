package com.revature;

import com.revature.models.LazySingleton;

public class SingletonDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LazySingleton ex1_2 = LazySingleton.getInstance();
		LazySingleton ex1_3 = LazySingleton.getInstance();
		System.out.println("ex1_2 == ex1_3? " + (ex1_2 == ex1_3));
	}

}
