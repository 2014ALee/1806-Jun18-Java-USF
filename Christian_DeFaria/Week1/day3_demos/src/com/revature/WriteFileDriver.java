package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {
	
	public static void main(String[] args) {
		BufferedWriter bw = null;
		String path = "C:\\Users\\Christian Defaria\\project-repos\\1806-Jun18-Java-USF\\Christian_DeFaria\\" + 
						"day3_demos\\Resources\\write_demo";
		
		try {
			
			String content = "Write this string to my file!";

			//Specify the file
			File myFile = new File(path);

			//Check to see if the file exists, if it doesn't create it
			if(!myFile.exists()) {
				myFile.createNewFile();
			}
			
			//Instanciate our Buffered Writer
			bw = new BufferedWriter(new FileWriter(myFile));
			
			//Write content to our file
			bw.write(content);
			System.out.println("Our file has been successfully written to!");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
