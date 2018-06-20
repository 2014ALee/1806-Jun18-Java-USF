package com.revature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {
	public static void main(String[] args) {
		String filePath = "D:\\batch-repos\\1806-Jun18-Java-USF\\Derek_Loisel\\day3_demos\\resources\\happy_text";
		FileReader fileReader;
		BufferedReader br; 

		//read from file using readLine
		try {

			fileReader = new FileReader(filePath);
			br = new BufferedReader(fileReader);

			System.out.println("Reading the file using the readLine() method");
			String line = br.readLine();

			//read the file until there are no more lines at the end of the file
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		}catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println("---------------------------------------------------------------");
		
		
		FileReader fileReader2;
		BufferedReader br2;
		
		//read from file using read
		try{
			fileReader2 = new FileReader(filePath);
			br2 = new BufferedReader(fileReader2);
			
			System.out.println("Reading the file using the read() method./n");
			
			int val = 0;
			char myChar;
			
			//read the file until its end (returns -1 when reaches end of file)
			while((val = br2.read()) != -1) {
				myChar = (char) val;
				System.out.print(myChar);
			}
			
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		 
	}
}
