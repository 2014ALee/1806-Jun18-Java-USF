/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q20FileReader.java
 * Code for Q20 of Core Java Assignment. Reads in a file and prints the information in a more human-friendly manner.
 */
package com.revature;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q20FileReader {
	public static void main(String[] args) {
		String line;
		String file = "/Users/ret/project-repos/1806-Jun18-Java-USF/Karen_Matney/core_java_assignment/src/main/resources/Data.txt";
		BufferedReader br;

		// Reading in
		try {
			br = new BufferedReader(new FileReader(file));

			line = br.readLine();
			while(line != null) {
				// Printing out in the new format
				System.out.println(humanReadable(line));
				line = br.readLine();
			}
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("A problem happened with closing the file");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			System.out.print("A problem happened with opening the file");
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.print("A problem happened with the input.");
			e.printStackTrace();
		}

	}

	static String humanReadable(String str) {
		String[] components;
		String output;

		components = str.split(":");

		output = "Name: " + components[0] + " " + components[1];
		output = output.concat("\nAge: " + components[2] + " years");
		output = output.concat("\nState: " + components[3] + " State\n");

		return output;
	}
}
