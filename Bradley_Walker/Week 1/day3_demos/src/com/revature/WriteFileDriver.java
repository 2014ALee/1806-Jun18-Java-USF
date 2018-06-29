package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

	public static void main(String[] args) {

		BufferedWriter bw = null;
		String path = "C:\\Users\\bradl\\repos\\1806-Jun18-Java-USF\\Bradley_Walker\\day3_demos\\Resources\\write_demo.txt";

		try {
			String content = "Write this string to the file";

			// Specify the file to write to
			File file = new File(path);

			// Check to see if the file exists. If not, create it
			if(!file.exists())
				file.createNewFile();

			// Instantiate our buffered writer
			bw = new BufferedWriter(new FileWriter(file));

			// Write content to the file
			bw.write(content);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
