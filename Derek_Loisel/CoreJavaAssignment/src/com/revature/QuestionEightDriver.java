package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionEightDriver {

	//Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
	//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”


	//use StringBuilder to see if the string equals the reverse of itself, if it does then it's a palindrome

	public static void main(String[] args) {

		//create an ArrayList of the Strings
		ArrayList<String> arrayList = createStringArrayList();
		
		//create an ArrayList of palindromes of the passed ArrayList of Strings
		ArrayList<String> palindromes = createPalindromesArrayList(arrayList);
		printPalindromes(palindromes);
	}

	private static ArrayList<String> createStringArrayList() {

		//add the strings to an array
		String[] arrayOfStrings = new String[] {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};

		//create an ArrayList
		ArrayList<String> stringArrayList = new ArrayList<String>();
		//add all the strings from the array to the ArrayList
		stringArrayList.addAll(Arrays.asList(arrayOfStrings));

		return stringArrayList;
	}

	private static ArrayList<String> createPalindromesArrayList(ArrayList<String> arrayList){

		//create ArrayList to return palindromes
		ArrayList<String> palindromesArray = new ArrayList<String>();

		//convert the passed arraylist of strings into an array so you can use StringBuilder
		String[] array = arrayList.toArray(new String[arrayList.size()]);

		//use a loop to create a stringbuilder for each array variable and check if its a palindrome using reverse, put it in the palindromes arraylist if it is

		for (String str : array)
		{

			//
			StringBuilder sb = new StringBuilder(str);
			if (str.equals(sb.reverse())) {
				//convert stringbuilder back to string before adding it to the arraylist
				String reversedStr = sb.reverse().toString();
				palindromesArray.add(reversedStr);
			}

		}

		//return the ArrayList of palindromes
		return palindromesArray;
	}
	
	private static void printPalindromes(ArrayList<String> palindromesList){
		
		for(String str : palindromesList) {
			
			System.out.println(str);
		}
		
	}
	
}
