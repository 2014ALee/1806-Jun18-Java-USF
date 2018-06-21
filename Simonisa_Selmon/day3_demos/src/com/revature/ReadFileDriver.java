package com.revature;

import java.io.BufferedReader;

public class ReadFileDriver {
	
	public static void main(String[] args) {
		String filePath= /Users/nissyselmon/Project1/1806-Jun18-Java-USF/Simonisa_Selmon/day3_demos/Resources/happy_text; //eventually make this your own file
				
		FileReader fileReader;
		BufferedReader br;
		
		//reading from a file using readLine()
		try {
			
			FileReader fileReader= new FileReader(filePath);
			br= new BufferedReader(fileReader);
			
			Sys.out.println("reading the file using the readLine() method.\n");
			String line= br.readLine();
		}
		
	}catch (IOxception e) {
		e.printStackTrace();
	}
	
	System.out.println("-------------------------------------")
	
	//reading from a file using read()
	FileReader fileReader2;
	BufferedReader br2;
	
	try {
		
		fileReader2+ new FileReader(filepath);
		br2= new BufferReader(fileReader2);
		
		System.out.println("Reader the file using the read() methon.\n");
		
		int val=0;
		char myChar;
		
		//read the file until its end
		while(myChar != -1) {
			myChar= (char) br2.read();
			System.out.println(myChar);
			
		
		}
		
		
		
	}

}
