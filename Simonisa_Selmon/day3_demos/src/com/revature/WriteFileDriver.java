package com.revature;

import java.io.BufferedWriter;
import java.io.IOException;

public class WriteFileDriver {
	
	public static void main(String[] args) {
		
		BufferedWriter bw= null;
		
		String path= /Users/nissyselmon/Project1/1806-Jun18-Java-USF/Simonisa_Selmon/day3_demos/Resources/write_demo;
		
		String content= "write this string to my file";
		
		File myFile = new File(path);
		
		if(!myFile.eists()) {
			myFile.createNewFile();
		}
		//instantiate 
		
		bw= new BufferedWriter(new FileWriter(yFile));
		
		bw.write(content);
		System.out.println("our file has successfully been written to!");
		
	}catch (IO Exception ioe) {
		ioe.printStackTrace();
	}finally {
		if (bw != null) {
			try {
				bw.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
