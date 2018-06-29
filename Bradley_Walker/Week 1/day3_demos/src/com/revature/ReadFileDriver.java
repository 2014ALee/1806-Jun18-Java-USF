package com.revature;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {

	public static void main(String[] args) {
		String filepath = "C:\\Users\\bradl\\repos\\1806-Jun18-Java-USF\\Bradley_Walker\\day3_demos\\Resources\\happy_text.txt";
		FileReader fileReader;
		// Grabs large chunks of the text at once. More memory efficient.
		BufferedReader br;

		try {
			fileReader = new FileReader(filepath);
			br = new BufferedReader(fileReader);

			System.out.println("Reading the file using the readLine() method\n\n");

			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedReader br2 = new BufferedReader(new FileReader(filepath));
			
			System.out.println("\nReading the file using the readLine() method\n\n");
			
			int val = 0;
			char myChar = 0;
			
			// Read the file to the end
			while((val = br2.read()) != -1) {
				myChar = (char) val;
				System.out.print(myChar);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
