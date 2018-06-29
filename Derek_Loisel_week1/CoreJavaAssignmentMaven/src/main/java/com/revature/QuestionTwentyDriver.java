package com.revature;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionTwentyDriver {
	//
	//	Q20. Create a notepad file called Data.txt and enter the following:
	//		Mickey:Mouse:35:Arizona
	//		Hulk:Hogan:50:Virginia
	//		Roger:Rabbit:22:California
	//		Wonder:Woman:18:Montana
	//		 
	//		Write a program that would read from the file and print it out to the screen in the following format:
	//		 
	//		Name: Mickey Mouse
	//		Age: 35 years
	//		State: Arizona State

	public static void main(String[] args) {
		System.out.println(formatFileText());
	}

	public static String formatFileText() {

		String formattedStr = "";					
		//create array list to hold the lines of text
		ArrayList<String> lines = new ArrayList<String>();
		//create file object
		File file = new File("D:\\batch-repos\\1806-Jun18-Java-USF\\Derek_Loisel\\CoreJavaAssignmentMaven\\src\\main\\resources\\Data.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			//scan each line of text to the file as a string to the array list
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		for(int i = 0; i < lines.size(); i++) {
			
			String temp = "";
			//split the line up into smaller strings
			String[] splits = lines.get(i).split(":");
			temp = "Name: " + splits[0] + " " + splits[1] + "\n" + "Age: " + splits[2] + " years\n" + "State: " + splits[3] + " State\n\n";
			//add the formatted line into the whole string
			formattedStr += temp;
		}		
		
		return formattedStr;
	}

}
