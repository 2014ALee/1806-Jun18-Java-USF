package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionEightDriver {

	//Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
	//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”


	//use StringBuilder to see if the string equals the reverse of itself, if it does then it's a palindrome

	public static void main(String[] args) {

		//add the strings to an array
		String[] arrayOfStrings = new String[] {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};

		//create an ArrayList
		ArrayList<String> stringArrayList = new ArrayList<String>();

		//add all the strings from the array to the ArrayList
		stringArrayList.addAll(Arrays.asList(arrayOfStrings));

		//create an ArrayList of palindromes from the passed ArrayList of Strings
		ArrayList<String> palindromes = createPalindromesArrayList(stringArrayList);

		//print the array of palindromes
		System.out.println(palindromes.toString());
//		for (String str : palindromes) {		
//			System.out.println(str);
//		}

	}


	public static ArrayList<String> createPalindromesArrayList(ArrayList<String> arrayList){

		//create ArrayList to return palindromes
		ArrayList<String> palindromesArray = new ArrayList<String>();

		//convert the passed arraylist of strings into an array so you can use StringBuilder
		String[] array = arrayList.toArray(new String[arrayList.size()]);

		//use a loop to create a stringbuilder for each array variable and check if its a palindrome using reverse, put it in the palindromes arraylist if it is

		for (String str : array)
		{
			//create string builder from the string
			StringBuilder sb = new StringBuilder(str);

			//reverse it and compare to the string
			String s1 = sb.reverse().toString();

			if (s1.equals(str)) {
				//equal
				palindromesArray.add(str);
			}else {
				//not equal
			}
		}

		//return the ArrayList of palindromes
		return palindromesArray;
	}

}
