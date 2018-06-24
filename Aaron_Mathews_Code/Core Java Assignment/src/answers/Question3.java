package answers;

public class Question3 {
	
	public static void main(String[] args) {
		String str = "Hello, world!";
		System.out.println(str);
		System.out.println(reverseString(str));
	}
	
	public static String reverseString(String str) {
		//Hint from Derek
		for (char myChar : str.toCharArray()) {
			str = myChar + str;
		}
		
		str = str.substring(0, str.length() / 2);
		return str;
	}

}
