package com.revature;
// read data from a file and print it appropriately
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Question20 {

	public static void main (String[] args) {

		String filePath = "C:\\batch-repos\\1806-Jun18-Java-USF\\Brandon_Scoggins_Code"
				+ "\\CoreJavaAssignment\\resources\\Data";

		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			while(line != null) {
				line = br.readLine();
				if (line != null)
					printLine(line);
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printLine(String line) {

		char[] charLine = line.toCharArray();

		String[] fields = new String[4];  			// more versatility from a collection but we know how many fields we will get

		int count = 0;
		int wordStart = 0;
		int wordEnd = 0;

		for(int i = 0; i < charLine.length; i++) {
			if (charLine[i] == ':') {
				wordEnd = i;
				fields[count++] = line.substring(wordStart, wordEnd);
				wordStart = wordEnd + 1;
			}

			if (i == (charLine.length - 1)) {
				wordEnd = charLine.length;
				fields[count++] = line.substring(wordStart, wordEnd);
			}
		}

		System.out.println("Name: " + fields[0] + " " + fields[1]);
		System.out.println("Age: " + fields[2] + " years");
		System.out.println("State: " + fields[3]);
		System.out.println();
	}
}
