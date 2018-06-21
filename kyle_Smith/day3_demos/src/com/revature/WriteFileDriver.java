package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {
	public static void main(String[] args) {

		BufferedWriter bw = null;
		String path = "D:\\revature\\project-repos\\javaUSF\\kyle_Smith\\day3_demos\\resources\\write_demo";
		
		try {
			String content = "write this string to the file";

			//		Specify the file that we are writing to
			File myFile = new File(path);

			//		Check to see if the file exists, if it doesn't we will create it
			if(!myFile.exists()) {
				myFile.createNewFile();
			}
			
//			Instantiate our BufferedWriter
			bw = new BufferedWriter (new FileWriter(myFile));
			
			//Write the content to our file
			bw.write(content);
			System.out.println("Our file has been successfully written to!");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if(bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
