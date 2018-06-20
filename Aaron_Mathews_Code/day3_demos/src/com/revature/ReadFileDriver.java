package com.revature;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {
	
	public static void main(String[] args) {
		/*
		 * FileReader opens file
		 * BufferedReader reads the information in the file
		 */
		
		String filePath = "C:\\Users\\aaron\\ProjectRepos\\1806-Jun18-Java-USF\\Aaron_Mathews_Code\\day3_demos\\Resources\\happy_text";
		FileReader fileReader;
		BufferedReader br = null;
		
		try {
			
			fileReader = new FileReader(filePath);
			br = new BufferedReader(fileReader);
			//System.out.println("Reading the file using th read.line() method.");
			
			String line = br.readLine();
			
			//Read file lines until there aren't any left
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
			
		//FileNotFoundException is an IOException. Catch both with one catch clause.	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		System.out.println("---------------------");
		
		FileReader fileReader2;
		BufferedReader br2 = null;
		
		try {
			
			fileReader2 = new FileReader(filePath);
			br2 = new BufferedReader(fileReader2);
			
			System.out.println("Reading the file using read() mething. \n");
			
			int val = 0;
			char myChar;
			
			while((val = br2.read()) != -1) {
				myChar = (char) val;
				System.out.print(myChar);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br2 != null) {
				try {
					br2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
