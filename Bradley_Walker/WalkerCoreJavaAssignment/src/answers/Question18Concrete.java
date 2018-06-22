package answers;

import java.util.Scanner;

public class Question18Concrete extends Question18Abstract {
	
	public static void main(String[] args) {
		
	}

	@Override
	public boolean containsUppercase(String str) {
		return !str.equals(str.toLowerCase());
	}

	@Override
	public String toLowercase(String str) {
		return str.toLowerCase();
	}

	@Override
	public void toInt(String str) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number: ");
		
		try {
			int i = Integer.parseInt(scan.nextLine());
		} catch (Exception e) {
			System.out.println("Invalid Input");
		}
	}

}
