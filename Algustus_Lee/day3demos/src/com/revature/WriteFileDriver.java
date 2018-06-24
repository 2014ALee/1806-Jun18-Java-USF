package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {
	public static void main (String[] args)
	{
		BufferedWriter bw = null;
		String path = "C:\\Users\\AlgustusLee-Laptop\\project-repos\\1806-Jun18-Java-USF\\Algustus_Lee\\day3demos\\Resources\\write_demo";
		try {
			String content = "Write this string to my file!";
			//Specify the file that we are writing to.
			File myFile = new File(path);
		
			//Check to see if the file exists, if it doesn't we will make it
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			// Instantiate our BufferedWriter
			bw = BufferedWriter
			
			//Write the content to our file
			bw.write(content);
			
			System.out.println("Our file has been successfully written to.");
		}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally {
			if(bw != null) {
				
				try {
					bw.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
		}
		}
	}

}
