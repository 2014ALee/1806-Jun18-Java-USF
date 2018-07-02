package com.revature;
// add strings to an array list and identify palindromes
import java.util.ArrayList;
import java.util.List;

public class Question8 {

	public static void main (String[] args) {
		
		List<String> fullList = new ArrayList<>();
		fullList.add("karan");
		fullList.add("madam");
		fullList.add("tom");
		fullList.add("civic");
		fullList.add("radar");
		fullList.add("jimmy");
		fullList.add("kayak");
		fullList.add("john");
		fullList.add("refer");
		fullList.add("billy");
		fullList.add("did");
		
		for (String s : fullList)
			System.out.print(s + "    ");
		
		System.out.println();
		
		List<String> palindromeList = new ArrayList<>();
		
		for (String s : fullList)
			if (isPalindrome(s))
				palindromeList.add(s);
		
		for (String s : palindromeList)
			System.out.print(s + "    ");
	}
	
	public static boolean isPalindrome(String s) {
		if(s.equals(reverseString(s)))
			return true;
		else
			return false;
	}
	
	public static String reverseString(String forwardString) {
		char[] forwardCharArray = forwardString.toCharArray();
		char[] reverseCharArray = new char[forwardCharArray.length];
		for(int i = 0; i < forwardCharArray.length; i++)
			reverseCharArray[forwardCharArray.length - i - 1] = forwardCharArray[i];
		return charArrayToString(reverseCharArray);
	}
	
	public static String charArrayToString(char[] charArray) {
		String s = "";
		for(char c : charArray)
			s += c;
		return s;
	}
}
