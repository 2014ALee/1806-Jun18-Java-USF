package answers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Question20 {
	// File IO

	public static void main(String[] args) {
		System.out.println(readFromFile());
	}

	public static String readFromFile() {
		String result = "";
		// Create the buffered reader
		try (BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
			// Read the first line
			String line = br.readLine();
			while(line != null) {
				// Split the string on the colons
				String[] comp = line.split(":");
				// Print the formatted string with the data inserted
				result += String.format("Name: %s %s\nAge: %s years\nState: %s State\n", comp[0], comp[1], comp[2], comp[3]);
				// Read the next line
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
