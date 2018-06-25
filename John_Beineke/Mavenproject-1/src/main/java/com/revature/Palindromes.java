package com.revature;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Palindromes {

	static ArrayList<String> arrayList2 = new ArrayList<>();

	public static void main(String[] args) {

		// Declare original arraylist
		ArrayList<String> arrayList1 = new ArrayList<>();
		arrayList1.add("karan");
		arrayList1.add("madam");
		arrayList1.add("tom");
		arrayList1.add("civic");
		arrayList1.add("radar");
		arrayList1.add("jimmy");
		arrayList1.add("kayak");
		arrayList1.add("john");
		arrayList1.add("refer");
		arrayList1.add("billy");
		arrayList1.add("did");

		// print original array to console
		System.out.print("Original ArrayList: ");
		System.out.println(arrayList1);

		System.out.println(" \n");

		System.out.print("ArrayList containing palindromes: ");
		
		// Check each string in original arraylist to see if it is a palindrome
		for (String str : arrayList1) {
			checkPalindrome(str);		
		}
		
		System.out.println(arrayList2);
	}

	public static ArrayList<String> checkPalindrome(String s)
	{
		
		// reverse String element
		String reverse = new StringBuffer(s).reverse().toString();

		// check whether the string is a palindrome or not
		// if it is, add it to the second arraylist otherwise return and move on to 
		// next string
		if (s.equals(reverse)) {
			arrayList2.add(s);
		}
		// Print the second arraylist containing just palindromes
		return arrayList2;
		}
	

}
