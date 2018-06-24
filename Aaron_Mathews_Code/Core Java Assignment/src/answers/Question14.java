package answers;

import java.util.Date;

public class Question14 {
	
	public static void main(String[] args) {
		String caseStr = "sqrt";
		testCases(caseStr);
	}
	
	public static void testCases(String caseStr) {
		caseStr.toLowerCase();
		switch(caseStr) {
		case "sqrt":
			System.out.println("The square root of 16 is: " + Math.sqrt(16));
			break;
		case "date":
			String date = new Date().toString();
			System.out.println(date);
			break;
		case "splitstring":
			String str = "I am learning Core Java";
			String[] splitStr = str.split(" ");			
			break;
		default:
			System.out.println("Invalid input.");
		}
	}

}
