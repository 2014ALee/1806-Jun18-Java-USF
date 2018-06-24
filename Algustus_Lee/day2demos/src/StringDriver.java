
public class StringDriver {
	public static void main(String[] args) {
		
		String str1= "hi";
		String str2= "hi";
		String str3= new String("hi");
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1 == str3);
		
		System.out.println("str changed to 'hello'");
		str2 = "hello";
		System.out.println(str1 == str2);
		System.out.println(str1);
		
		//replaceAll
		String test = "here is my string, isn't it cool?";
		test.replaceAll(" ", "_");
		System.out.println(test); //doesn't change the text, strings cannot be changed.
		
		System.out.println(test.replaceAll(" ", "_")); //makes a copy of the string and changes it.
		
		//charAt
		String original = "original String";
		System.out.println(original.charAt(5));
		
		//there's also lower/uppercase functions, and endswith operators.
		
		/*
		 * Strings are immutable, StringBuilder is not.
		 * 
		 * StringBuilder
		 */
		
		StringBuilder strBldr1 = new StringBuilder("My StringBuilder Object!");
		StringBuilder strBldr2 = new StringBuilder("My StringBuilder Object!");

	}
}
