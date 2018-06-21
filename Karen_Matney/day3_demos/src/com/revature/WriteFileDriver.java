package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {
	public static void main(String[] args) {
		BufferedWriter bw = null;
		String path = "/Users/ret/project-repos/1806-Jun18-Java-USF/Karen_Matney/day3_demos/resources/WriteTest.txt";
		try {
			String content = "Write this string to my file!";

			// Specify the file that we are writing to
			File myFile = new File(path);

			// Check to see if the file exists, if it doesn't we will create it
			if(!myFile.exists()) {
				myFile.createNewFile();
			}
			
			bw = new BufferedWriter(new FileWriter(myFile)); // More memory 

			bw.write(content);
			
			System.out.println("Our File has been successfully written to.");
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
