package com.revature;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question20 {
	public static void main(String[] args) {
		/*
		 * Declare buffer for use, simplify filepath, and create
		 * an ArrayList to store each line.
		 */
		final String FILE_PATH = "C:\\Users\\Andrew\\1806-Jun18-Java-USF\\andrew_li_code\\Core_Java_Assignments\\Core_Java_Assignment_1\\Core_Java_Assignment\\resources\\data.txt";
		BufferedReader br = null;
		List<String> lines = new ArrayList<String>();
		
		/*
		 * Attempting to read the lines from our file.
		 */
		try {
			br = new BufferedReader(new FileReader(FILE_PATH));
			String line = br.readLine();
			/*
			 * Keep reading lines until there are no longer
			 * any lines.
			 */
			while (line != null) {
				lines.add(line);
				line = br.readLine();
			}
		// Exiting if there's an exception.
		} catch (FileNotFoundException e) {
			System.out.println("Error in reading the file.");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		/*
		 * Closing the file if possible.
		 */
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("[LOG] Failed to close file");
		}
		
		System.out.println("____________________________________________________________\n");
		System.out.println("Displaying data.");
		System.out.println("____________________________________________________________\n");
		for (String line : lines) {
			String[] words = line.split(":");
			/*
			 * Break out if the format is incorrect.
			 */
			if (words.length != 4) {
				System.out.println("[LOG] Error reading file.");
				break;
			}
			String display = "";
			// Name: [firstName] [lastName]
			display += "Name: " + words[0] + " " + words[1] + "\n";
			// Age: [age] years
			display += "Age: " + words[2] + " years\n";
			// State: [state] State
			display += "State: " + words[3] + " State";
			System.out.println(display);
			System.out.println("____________________________________________________________\n");
		}
	}
}
