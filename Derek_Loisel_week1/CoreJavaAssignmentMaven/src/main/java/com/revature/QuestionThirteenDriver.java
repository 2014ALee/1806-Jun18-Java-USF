package com.revature;

public class QuestionThirteenDriver {

	public static void main(String[] args) {
		
		System.out.println(createTriangle(4));
	}
	public static String createTriangle(int n) {
		
		//return a triangle string
		String str = "";
		
		// b controls whether it prints 0 or 1
		boolean oneOrZero = true;
		
		//a represents each row in the triangle
		for(int a = 0; a < n; a++) {
			for(int b = 0; b <= a; b++) {	
				//if true print 0 else print 1
				if (oneOrZero) {
					str += 0;
				}else {
					str += 1;
				}					
				// Switch output
				oneOrZero = (oneOrZero) ? false : true;
			}
					
			//new line
			str += "\n";
		}
		
		return str;
	}
	
}
