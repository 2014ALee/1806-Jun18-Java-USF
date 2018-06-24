package homework_week1.questions;

public class Question5 {

public static String computeSubstring(String str, int index) {
	char[] subStringCharArray = new char[index];
	String subString;
	
	
	for(int i=0 ; i< index ; i++) {
		subStringCharArray[i] = str.charAt(i);		
	}
	
	subString = new String(subStringCharArray);
	
return subString;	
}



	public static void main(String[] args) {
	
		System.out.println(computeSubstring("Andrew",4));
		
		
	}
}
