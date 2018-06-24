package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Q8 {
	public static void main(String[] args)
	{
		//makes two lists, one for what we pass into it and the other to hold the palindromes
		List<String> theList = new ArrayList<>();
		List<String> theOtherList = new ArrayList<>();
		theList.add("karan");
		theList.add("madam");
		theList.add("tom");
		theList.add("civic");
		theList.add("radar");
		theList.add("jimmy");
		theList.add("kayak");
		theList.add("john");
		theList.add("refer");
		theList.add("billy");
		theList.add("did");


		System.out.println("The first List: "+theList);
		System.out.println("The second List: " + palindromeChecker(theList, theOtherList));
	}

	//checks for palindrome by running every element in the first list passed into it through a reverser
	public static List<String> palindromeChecker(List<String> aList, List<String> blist) {
		for(int i = 0; i < aList.size(); i++ )
		{
			//if the element is a palindrome (checked here) add it to blist
			if(aList.get(i).equals(stringReverser(aList.get(i))))
			{
				blist.add((aList.get(i)));
			}

		}
		return blist;

	}
	//exact same method from Q3
	public static String stringReverser(String strToBeReversed)
	{
		for(int i = 0; i < strToBeReversed.length(); i++) {
			strToBeReversed = strToBeReversed.substring(0, i)+strToBeReversed.charAt(strToBeReversed.length()-1)+strToBeReversed.substring(i, strToBeReversed.length()-1);
		}
		return strToBeReversed;
	}

}
