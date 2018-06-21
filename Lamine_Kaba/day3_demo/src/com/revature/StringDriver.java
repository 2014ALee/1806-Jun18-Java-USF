package com.revature;

public class StringDriver {
	public static void main(String[] args) {
		
		// StringBuilder
		/*
		 * mutable
		 * not tread - safe
		 */
		
		StringBuilder stringBuilder1 = new StringBuilder("I'm string builder object");
		StringBuilder stringBuilder2 = new StringBuilder("I'm string builder object");
		
		System.out.println("stringBuilder1 hashcode = " + stringBuilder1.hashCode());
		System.out.println("stringBuilder1 hashcode = " + stringBuilder2.hashCode());
		System.out.println("stringBuilder1.equals(stringBuilder2) = " + stringBuilder1.hashCode());
		
		// When converted into strings they hascode will be equal
		
		System.out.println(stringBuilder1.toString().hashCode());
		System.out.println(stringBuilder2.toString().hashCode());
		
		// But they will not point to the same object in memory
		
		//System.out.print(stringBuilder1.toString().hashCode());
		
		// Since the stringBuilder is mutable, appending to it will change the origine
		
		StringBuilder stringBuilder3 = new StringBuilder("Hello");
		System.out.println(stringBuilder3);
		stringBuilder3.append(" World");
		
		System.out.println(stringBuilder3);
	}

}
