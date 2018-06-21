package homework_week1;

public class ReverseString {
	public static String reverseString(String str){
		String reversedString="";
		
		for(int i = str.length()-1; i >= 0 ; i--) {
			reversedString = reversedString.concat(str.substring(i,i+1));
		}		
		return reversedString;
	}
	

	public static void main(String[] args) {
		
		String str = reverseString("My name is Tom!");
		System.out.println(str);
		
	}
	
	
}
