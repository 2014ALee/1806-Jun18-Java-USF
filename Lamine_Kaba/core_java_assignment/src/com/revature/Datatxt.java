package com.revature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Datatxt {
	
	public static void datatxt() throws IOException {
		
		String myFilePath = "C:\\Users\\lkaba\\Desktop\\project-repos\\1806-Jun18-Java-USF\\Lamine_Kaba\\core_java_assignment\\src\\com\\revature\\Data.txt";
		File myFile = new File(myFilePath);
		FileReader myReader = new FileReader(myFile);
		BufferedReader myBr = new BufferedReader(myReader);
		
		if(!myFile.exists()) {
			System.out.println("Error! file does not exit");
		}
		else {
			String myLineReader = myBr.readLine();
			while(myLineReader != null) {
				String[] separator = myLineReader.split(":");
				System.out.printf("Name: %s %s\nAge: %s \nState: %s State", separator[0], separator[1], separator[2], separator[3]);
				System.out.println("\n");
				myLineReader = myBr.readLine();
			}
			
		}
	}

}












