package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

	public static void main(String[] args) {
		
		BufferedWriter bw =null;
		String path = "C:\\Users\\Teddy\\1806-Jun18-Java-USF\\Theodore Smith\\day3_demos\\resource\\Untitled 2";
		
		try {
			
		
		String content = "Write this string to my file!";
		
		
		File myFile = new File(path);
		
		if (!myFile.exists()) {
			myFile.createNewFile();
		}
		
		bw = new BufferedWriter(new FileWriter(myFile));
		
		bw.write(content);
		
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			if(bw != null) {
				try {
					bw.close();	
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
