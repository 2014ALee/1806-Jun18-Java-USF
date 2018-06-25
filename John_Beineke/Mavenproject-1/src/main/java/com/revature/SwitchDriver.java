package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SwitchDriver {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("[1] - Find Square Root of 237");
		System.out.println("[2] - Display Today's Date");
		System.out.println("[3] - Split String");
		
		System.out.println("Please choose an option: ");
		
		String choice;
		try {
			choice = br.readLine();
			
			switch(choice) {
			case "1":
				int num = 237;
				System.out.println("Square Root: " + Math.sqrt(num));
				break;
			case "2":
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date date = new Date();	
				System.out.println(dateFormat.format(date));			
				break;
			case "3":
				String str = "I am Learning Core Java";
				String[] strings = str.split(" ");
				System.out.println(Arrays.toString(strings));
				break;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
