package homework_week1.questions;

public class Question5 {

	//the method below gives us the substring from index 0 to a specified index
	public static String computeSubstring(String str, int index) {
		char[] subStringCharArray = new char[index];
		String subString;

		//we place each char needed for our substring into a char array
		for(int i=0 ; i< index ; i++) {
			subStringCharArray[i] = str.charAt(i);		
		}

		//finally, we convert the array back into a string 
		subString = new String(subStringCharArray);

		return subString;	
	}



	public static void main(String[] args) {

		System.out.println(computeSubstring("Andrew",4));


	}
}
