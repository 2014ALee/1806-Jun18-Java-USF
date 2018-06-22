package homework_week1;

public class ReverseString {
	public static String reverseString(String str){

		//this is the last index in our string
		int lastIndex = str.length()-1;

		//below we add letters to the original string in reversed order creating a
		//long string with the original string and the reversed one together in one string
		for(int i = 0 ; i <= lastIndex ; i++) {			
			str=str.concat(str.substring(lastIndex-i,lastIndex-i+1));
		}

		//now we remove the first half of our string so that only the reversed portion remains
		str = str.substring(lastIndex+1);		
		return str;	
	}	

	public static void main(String[] args) {
		String str = "My name is Tom";
		str = reverseString(str);
		System.out.println(str);

	}


}
