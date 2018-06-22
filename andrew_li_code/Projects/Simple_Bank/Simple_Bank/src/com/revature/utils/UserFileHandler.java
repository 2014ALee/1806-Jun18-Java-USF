package com.revature.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserFileHandler {
	// The name of the path is here.
	private static final String PATH_NAME = System.getProperty("user.dir") + "\\resources\\users";
	// Determine the filePath that we will use.
	private String filePath;
	
	// Create the handler for a specific username.
	public UserFileHandler(String username) {
		username = username.toLowerCase();
		this.filePath = PATH_NAME + "\\" + username + ".txt";
	}
	
	// Check if file exists, before trying to read to it
	// If not, the user might have entered an invalid username
	public boolean hasFile() {
		/*
		 * Return null if File doesn't exist.
		 */
		return (new File(this.filePath).exists());	
	}
	/*
	 * Create a file if file does not exist. This will
	 * be used when checking for username availability.
	 */
	public boolean createFile() throws IOException {
		File file = new File(this.filePath);
		if (file.exists()) {
			return false;
		} else {
			file.createNewFile();
			return true;
		}
	}
	/*
	 * Attempt to read the file, return null if there's
	 * a problem. There shouldn't be a FileNotFoundException
	 * due to previous method, so if it returns null, there's
	 * likely an IOException.
	 */
	public String readFile() {
		String text = "";
		boolean notClosing = true;
		
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(this.filePath));
			String line = br.readLine();
			while (line != null) {
				text += line;
				line = br.readLine();
			}
			notClosing = false;
			br.close();
			// FileNotFoundException should not occur.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
			/*
			 * If there's an IOException from trying to close,
			 * we read the text.
			 */
		} catch (IOException e) {
			e.printStackTrace();
			if (notClosing) {
				return null;
			}
		}
		
		return text;
	}
	/*
	 * Writing to file. Return true if file has been
	 * written to, and false if it has not.
	 */
	public boolean writeNewFile(String text) {
		boolean output = false;
		
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(this.filePath));
			bw.write(text);
			bw.flush();
			output = true;
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
}
