package answers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Question20 {

	public static void main(String[] args) {
		String fileName = "Data.txt";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String firstLine = br.readLine();
			
			String[] split = firstLine.split(":");
			
			String name = "Name: " + split[0] + " " + split[1];
			String age = "Age: " + split[2] + " years";
			String state = "State: " + split[3] + " State";
			
			System.out.println(name);
			System.out.println(age);
			System.out.println(state);
			
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate file. Please try again.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while reading from file. Please try again.");
			e.printStackTrace();
		}
	}

}
