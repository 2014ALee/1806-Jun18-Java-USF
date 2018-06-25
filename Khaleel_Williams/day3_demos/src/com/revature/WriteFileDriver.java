package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

	public static void main(String[] args) {
		
		BufferedWriter bw = null;
		String path = "C:\\Users\\Cry\\project-repos\\1806-Jun18-Java-USF\\" 
					+ "Khaleel_Williams\\day3_demos\\Resources\\write_demo";
		
		try {
			String content = "Write this string to my file!";
		
			// Specify the file that we are writing to
			File myFile = new File(path);
		
			// Check to see if the file exists, if it doesn't we will create it
			if(!myFile.exists()) {
				myFile.createNewFile();
			}
			
			// Instantiate our BufferedWriter
			bw = new BufferedWriter(new FileWriter(myFile));
			
			// Write the content to our file
			bw.write(content);
			
			bw.write("testing writing strings");
			
			System.out.println("Our file has been successfully written to!");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}