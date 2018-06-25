package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

	public static void main(String[] args) {
		BufferedWriter bw = null;
		String path = "C:\\batch-repos\\1806-Jun18-Java-USF\\Brandon_Scoggins_Code"
						+ "\\day3_demos\\resources\\write_demo";
		try {
			String content = "Write this to my file!";
		
			// Specifiy the file that we are writing to
			File myFile = new File(path);
			
			// If the file does not exist, we will create it
			if(!myFile.exists()) {
				myFile.createNewFile();
			}
			
			// Instantiate our bufferedWriter
			bw = new BufferedWriter(new FileWriter(myFile));
			
			// Write content to the file
			bw.write(content);
			bw.write("\n");
			bw.write("hello");
			
			System.out.println("Our file has been successfully written to.");
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			if(bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
}
