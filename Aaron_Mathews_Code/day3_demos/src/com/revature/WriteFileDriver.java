package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

	public static void main(String[] args) {

		BufferedWriter bw = null;
		String path = "C:\\Users\\aaron\\ProjectRepos\\1806-Jun18-Java-USF\\Aaron_Mathews_Code\\day3_demos\\Resources\\write_demo";

		try {
			
			String content = "Write this string to my file";

			//Specify the file that we writing to 
			File myFile = new File(path);

			//Check to see if the file exists. If not, create it.
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			
			//Instantiate our BufferWriter
			bw = new BufferedWriter(new FileWriter(myFile));
			
			bw.write(content);
			System.out.println("File successfully written to");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
