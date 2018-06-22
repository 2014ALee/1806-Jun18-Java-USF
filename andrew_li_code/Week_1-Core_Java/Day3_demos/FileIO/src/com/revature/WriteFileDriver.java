package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		String path = "C:\\Users\\Andrew\\1806-Jun18-Java-USF\\andrew_li_code\\Week_1-Core_Java\\Day3_demos\\FileIO\\resources\\write_demo.txt";
		
		// Check to see if the file exists. IF not, create.
		try {
		    String content = "Write this second string to my file!";
		    File myFile = new File(path);
		    if (!myFile.exists()) {
					myFile.createNewFile();
		    }		
			//Instantiate Buffered Writer
		    bw = new BufferedWriter(new FileWriter(myFile));
		    
		    bw.write(content);
		    
		    System.out.print("Our file has been successfully written to!\n");
		    bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
