package answers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Question20 {
	// File IO

	public static void main(String[] args) {
		// Create the buffered reader
		try (BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
			// Read the first line
			String line = br.readLine();
			while(line != null) {
				// Split the string on the colos
				String[] comp = line.split(":");
				// Print the formatted string with the data inserted
				System.out.printf("Name: %s %s\nAge: %s years\nState: %s State", comp[0], comp[1], comp[2], comp[3]);
				System.out.println("\n");
				// Read the next line
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
