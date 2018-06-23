package com.revature;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

	
	public static void main(String[] args) {
		File file = new File("D:\\revature\\projects\\src\\com\\revature\\resources\\Data.txt");
		fileRead(file);
	}
	
	public static void fileRead(File file) {
	    Scanner sc;
		try {
			sc = new Scanner(file);
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
			  lines.add(sc.nextLine());
			}
			String[] arr = lines.toArray(new String[0]);
			for (int i = 0;i < arr.length; i++) {
				System.out.println("Name: " + (arr[i].split(":")[0]) +" "+ (arr[i].split(":")[1]) );
				System.out.println("Age: " + (arr[i].split(":")[2])+ " years");
				System.out.println("State: " + (arr[i].split(":")[3])+ " state");
				System.out.println("");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 

	}
}
