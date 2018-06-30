package com.revature;

import java.io.BufferedReader;
// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {
	public static void main(String[] args) {
		String filePath = "/Users/ret/project-repos/1806-Jun18-Java-USF/Karen_Matney/day3_demos/resources/BobRossQuotes.txt";
		FileReader fileReader;
		BufferedReader br;

		// Reading from a file using readLine()
		try {
			fileReader = new FileReader(filePath);
			br = new BufferedReader(fileReader);

			System.out.println("Reading the file using the readLine() method.");
			String line = br.readLine();

			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException fnfe) {
			fnfe.printStackTrace();
		}

		System.out.println("-------------------------------------------");

		// Reading from a file using read()
		FileReader fileReader2;
		BufferedReader br2;

		try {
			fileReader2 = new FileReader(filePath);
			br2 = new BufferedReader(fileReader2);

			System.out.println("Reader the file using the read() method.\n");

			int value = 0;
			char myChar;

			// Read until EOF
			while((value = br2.read()) != -1) {
				myChar = (char)value;
				System.out.print(myChar);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}