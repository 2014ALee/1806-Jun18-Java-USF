package homework_week1.questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Question20 {

	public static String[] readFromFile(String fileName) throws FileNotFoundException, IOException {

		try(FileReader fileReader = new FileReader(fileName)){

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			//line holds the next line found in the file reader
			String line = bufferedReader.readLine();

			while(line!=null) {

				String [] splitString = line.split(":");

				//here we print out the string read from the file, with other text added
				System.out.println("Name: " + splitString[0] + " " + splitString[1]);
				System.out.println("Age: " + splitString[2] + " years");
				System.out.println("State: " + splitString[3] + " State");
				System.out.println();			
				line = bufferedReader.readLine();

			}
		}

		return null;
	}

	public static void main(String[] args) {

		try {

			readFromFile("Data.txt");

		} catch (FileNotFoundException e1) {

			System.out.println("The file was not found...");

		} catch (IOException e2) {

			System.out.println("An error occured when trying to read from the file...");

		}
	}
}
