package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

	public static void main(String[] args) {
		BufferedWriter bw = null;
		String path = "C:\\Users\\Tom Steyaert\\1806-Jun18-Java-USF\\Tom_Steyaert\\day3_demos\\Resources\\write_demo";
		try {
			File myFile = new File(path);
			String content = "write this in my file";
			if(!myFile.exists()) {

				//check to see if the file exists, if it doesn't we will create it
				myFile.createNewFile();
			}


			bw =  new BufferedWriter(new FileWriter(myFile));
			bw.write(content);
			System.out.println("we successfully wrote to out file");

		} catch (IOException e) {				
			e.printStackTrace();
		}finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}

}

