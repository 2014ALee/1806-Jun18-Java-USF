package com.revature;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {

	public static void main(String[] args) {
		
		String filePath = "C:\\batch-repos\\1806-Jun18-Java-USF\\Brandon_Scoggins_Code"
							+ "\\day3_demos\\resources\\write_demo";
		
		FileReader fileReader;
		BufferedReader br;
		
		try{
			fileReader = new FileReader(filePath);
			br = new BufferedReader(fileReader);
			
			System.out.println("Reading the file using the readLine() method.");
			String line = br.readLine();
			
			// Read the file until there are no more lines (the end of the file)
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("---------------------------------------------------------------------");
		
		// Reading from a file using read()
		FileReader fileReader2;
		BufferedReader br2;
		
		try {
			fileReader2 = new FileReader(filePath);
			br2 = new BufferedReader(fileReader2);
			
			System.out.println("Reader the file using the read() method.\n");
			
			int val = 0;
			char myChar;
			
			// Read the file until its end
			while((val = br2.read()) != -1) {
				myChar = (char) val;
				System.out.print(myChar);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
