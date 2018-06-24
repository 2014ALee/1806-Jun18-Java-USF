package com.revature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {
	public static void main(String[] args) {
		//the path to get the data.txt file
		String filePath = "C:\\Users\\AlgustusLee-Laptop\\project-repos"+
	"\\1806-Jun18-Java-USF\\Algustus_Lee\\CoreJavaAssignment\\src\\data.txt";
		
		//gets inputs (hey, I didn't use scanner this time!)
		FileReader reader;
		BufferedReader bReader;
		
		//try/catch block in case a pointer hits a null or in case of an I/O failure
		try {
			
			reader = new FileReader(filePath);
			bReader = new BufferedReader(reader);
			//gets a string of the incoming data as the BufferedReader reads it in
			String incoming = bReader.readLine();
			while(incoming != null)
			{
				//splits the incoming data by the colon it has, then prints it out in the required sequence
				String[] incomingData = incoming.split(":");
				
				System.out.println("Name: "+incomingData[0]+" "+incomingData[1]);
				System.out.println("Age: "+incomingData[2]+" years");
				System.out.println("State: "+incomingData[3]+" State");
				System.out.println();
				//sets the reader to jump back to the next line unless it is read as null.
				incoming = bReader.readLine();
			}
			
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
