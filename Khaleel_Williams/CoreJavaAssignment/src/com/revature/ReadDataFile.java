package com.revature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadDataFile {

	public static void main(String[] args) {
			readFile();
	}
	
	
	public static boolean readFile() {
		String filePath = "C:\\Users\\Cry\\project-repos\\1806-Jun18-Java-USF\\"
				+ "Khaleel_Williams\\CoreJavaAssignment\\Resources\\Data.txt";
		FileReader read = null;
		String line = null;
		int count = 0;
		String strArray[] = new String[4];
		String strArray2[][] = new String[4][4];

		try {
			read = new FileReader(filePath);
			BufferedReader buffRead = new BufferedReader(read);


			while ((line = buffRead.readLine()) != null) {
				strArray2[count] = line.split(":");
				count++;

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File does not exist");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count = 0;

		for (String[] s : strArray2) {
			System.out.println( "Name: " + strArray2[count][0] + " " + strArray2[count][1]);
			System.out.println( "Age: " + strArray2[count][2] + " years");
			System.out.println( "State: " + strArray2[count][3] + " state");
			System.out.println( "\r\n--------------------------\n");
			count++;
		}
		return true;

	}


}
