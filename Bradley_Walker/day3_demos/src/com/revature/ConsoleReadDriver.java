package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReadDriver {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		System.out.print("Enter some text: ");
		
		try {
			input = br.readLine();
		}catch(IOException e) {
			System.out.println("Invalid Input");
			e.printStackTrace();
			main(args);
		}
		
		System.out.println("You entered: " + input);
		
		System.out.println("-------------------");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter some more text: ");
		String value = scan.nextLine();
		System.out.println("You entered: " + value);
		
	}

}
