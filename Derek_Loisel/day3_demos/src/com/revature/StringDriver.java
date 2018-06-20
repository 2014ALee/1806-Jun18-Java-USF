package com.revature;

public class StringDriver {
	
	public static void main(String[] args) {
		
	String string1 = "I'm a string";
	String string2 = "I'm a string";
	
	/*
	 * modifying a string's value will reference a new object; this is reflected
	 * in the .hashCode() of the objects
	 */
	System.out.println("string 1 hashcode = " + string1.hashCode());
	System.out.println("string 2 hashcode = " + string2.hashCode());
	
	string1 = string1 + "!";
	System.out.println("string 1 hashcode = " + string1.hashCode());

	
	/*
	 * StringBuilders
	 * -mutable
	 * -not thread safe
	 */
	/*
	 * StringBuffers
	 * -mutable
	 * -thread safe* only main difference
	 */
	
	StringBuilder stringBuilder1 = new StringBuilder("I'm a string builder object!");
	StringBuilder stringBuilder2 = new StringBuilder("I'm a string builder object!");

			System.out.println("stringBuilder1 hashcode = " + stringBuilder1.hashCode());
			System.out.println("stringBuilder2 hashcode = " + stringBuilder1.hashCode());
			
			System.out.println("stringBuilder1.equals(stringBuilder2) = " + stringBuilder1.equals(stringBuilder2)); //false
	
			//when stringbuilders with equal values are converted into strings, their hashCodes will be equal
			System.out.println(stringBuilder1.toString().hashCode());
			System.out.println(stringBuilder2.toString().hashCode());
			
			//but they will not point to the same object in memory
			System.out.println(stringBuilder1 == stringBuilder2);//false
	
			//executing methods on strings without capturing their return does not change the value of the string
			
			//since stringbuilder objects are mutable, appending to it will change the original string object
	
	
	//include a throws clause on a methods signature to force any calling method to handle it.
			/*
			public static void throwSomething() throws IOException {
				System.out.println("This method might throw an exception");
				
			}
			*/
	}
}
