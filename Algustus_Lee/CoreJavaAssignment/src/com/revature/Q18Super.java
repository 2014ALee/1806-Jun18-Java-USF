package com.revature;
/*
 * Superclass for Q18
 */

public class Q18Super { 

	//loops through a string that is passed in, checks if the char is equal to its uppercase counterpart. if there are
	//any uppercase letters, it is returned true.
	public static boolean upperChecker(String getString)
	{
		for (int i = 0; i < getString.length(); i++)
		{
			if(getString.charAt(i) == getString.toUpperCase().charAt(i))
			{
				return true;
			}
		}
		return false;

	}
	
	//has a string passed in, creates a new string which is set equal to the passed in string with
	//everything set to uppercase. Returns the new string.
	public static String upperConverter(String getString)
	{
		String gotString = getString.toUpperCase();
		
		
		return gotString;
		
	}
	
	//gets a string that has a numeric value. creates an int which is set to become the numeric value specified by the string
	//adds ten to that int
	public static int addToString(String getString)
	{
		int add = Integer.parseInt(getString); 
		
		return add + 10;
		
	}
	

}
