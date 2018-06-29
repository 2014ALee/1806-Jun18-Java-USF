package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {
	public static void main(String[] args) {

		BufferedWriter bw = null;
		String path = "D:\\batch-repos\\1806-Jun18-Java-USF\\Derek_Loisel\\day3_demos\\resources\\write_demo";



		//check to see if the file exists, if it doesn't we'll create it


		try {

			String content = "Write this string to my file!";

			//specify the file that we're writing to
			File myFile = new File(path);

			if (!myFile.exists()) {

				myFile.createNewFile();
			}

			//instantiate our BufferedWriter
			bw = new BufferedWriter (new FileWriter(myFile));

			//write the content to our file
			bw.write(content);

			System.out.println("our file has been successfully written to!");

		} catch (IOException e) {
			e.printStackTrace();
		} 
		//using finally to close out the file
		finally {
			if(bw != null) //need to check if null so you dont use a method on a null object
				try {
					bw.close(); 
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}


}

