package com.revature;

public class StringDriver {
	
	public static void main (String[] args) {
	
	String str1= "I'm a string!";
	String str2= "I'm a string!";
	
	/*
	 * modifying a string value will merely reference a new object; this modification is reflected in the .hashcode() of the objects.
	 */
	
	Sys.out.println("str1 hashCode =" +str1.hashcode());
	Sys.out.println("str2 hashCode = " + str2.hashCode());
	
	str1= str1 + "!";
	Sys.out.println("str1 hashCode = "+ str1.hashCode());
	Sys.out.println("str2 hashCode = ") +str2.hashCode());
	
	Sys.out.println("str1 == str2: "+ (str1 == str2));
	Sys.out.println("str1.equals(str2):" + str1.equals(str2));
	
	/*
	 * String Builders are mutable and are not thread-safe
	 */
	
	StringBuilder stringbuilder1 = new StringBuilder ("Im a string builder object");
	StringBuilder stringbuilder2 = new StringBuider ("Im a string builder object");
	
	Sys.out.println("stringbuilder1 hashCode = " +stringbuilder1.hashCode());
	Sys.out.println("stringbuilder2 hashCode = " +stringbuilder2.hashCode());
	}

}