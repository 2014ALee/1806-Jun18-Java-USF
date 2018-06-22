package com.revature;

import java.io.*;

public class ReadFileDriver {

	public static void main(String[] args) {
		FileReader fileReader;
		String fileName = "C:\\Users\\Andrew\\1806-Jun18-Java-USF\\andrew_li_code\\Week_1-Core_Java\\Day3_demos\\FileIO\\resources\\happy_text.txt";
		BufferedReader br;
		
		// Reading from a file using readLine()
		try {
			fileReader = new FileReader(fileName);
			br = new BufferedReader(fileReader);
			
			System.out.println("Reading the file using the readLine(); method.");
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileReader fileReader2;
		BufferedReader br2;
		
		try {
			fileReader2 = new FileReader(fileName);
			br2 = new BufferedReader(fileReader2);
			
			System.out.println("Reader the file using the read() method\n");
			
			int val = 0;
			char myChar;
			
			while ((val = br2.read()) != -1) {
				System.out.print(((char) val));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
