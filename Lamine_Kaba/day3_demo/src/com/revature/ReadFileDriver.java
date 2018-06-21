package com.revature;

import java.io.*;

public class ReadFileDriver {

	public static void main(String[] args) {
		
		String filePath = "C:\\Users\\lkaba\\Desktop\\project-repos\\1806-Jun18-Java-USF\\"
				+ "Lamine_Kaba\\day3_demo\\resources\\readMyFile";
		
		FileReader fileReader;
		BufferedReader br;
		
		try {
			fileReader = new FileReader(filePath);
			br = new BufferedReader(fileReader);
			
			System.out.println("Reading the file using the readline() method");
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------------------------------------------------");
	
		// Reading from a file using read()
		FileReader fileReader2;
		BufferedReader br2;
		
		try {
			fileReader2 = new FileReader(filePath);
			br2 = new BufferedReader(fileReader2);
			
			System.out.println("Reader the file using the read() method.\n");
			
			int val = 0;
			char myChar;
			
			// read the file until its end
			while((val = br2.read()) != -1) {
				myChar = (char) val;
				System.out.print(myChar);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}	
		
	}
}










