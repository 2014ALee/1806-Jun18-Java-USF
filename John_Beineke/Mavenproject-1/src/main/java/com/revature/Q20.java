package com.revature;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Q20 {

	public static void main(String[] args) {

		String filePath = "C:\\Users\\jbein\\Project-Repos\\1806-Jun18-Java-USF\\John Beineke\\Maven_Project01_junit\\src\\main\\java\\com\\revature\\models\\data.txt";

		FileReader fileReader;
		BufferedReader br;

		// Reading from a file using readLine()
		try {

			fileReader = new FileReader(filePath);
			br = new BufferedReader(fileReader);
			String line = br.readLine();

			// read the file until there are no more lines in the file
			while( line != null) {
				// Split the string at the colons
				String[] splitString = line.split(":");
				System.out.println("Name: " + splitString[0] + " " + splitString[1]);
				System.out.println("Age: " + splitString[2] + " years");
				System.out.println("State: " + splitString[3] + " State");
				System.out.println();			
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Could not find specified file...");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
