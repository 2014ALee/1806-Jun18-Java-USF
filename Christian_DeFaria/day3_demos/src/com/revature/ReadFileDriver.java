package com.revature;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {
	
	public static void main(String[] args) {
		
		String filePath = "C:\\Users\\Christian Defaria\\project-repos\\1806-Jun18-Java-USF\\Christian_DeFaria"
				+	"\\day3_demos\\Resources\\happy.txt";
	
		FileReader fileReader;
		BufferedReader br;
		
		try {
			fileReader = new FileReader(filePath);
			br = new BufferedReader(fileReader);
			
			System.out.println("Reading the file using the readLine() method.");
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("--------------------------------------------");
		//Reading from a file using the read() method
		FileReader fileReader2;
		BufferedReader br2;
		try {
			fileReader2 = new FileReader(filePath);
			br2 = new BufferedReader(fileReader2);
			
			System.out.println("Reader using the file using the read() method.\n");
			
			int val = 0;
			char myChar;
			
			//read the file until its end
			while((val = br2.read()) != -1) {
				myChar = (char) val;
				System.out.print(myChar);
			} 
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}