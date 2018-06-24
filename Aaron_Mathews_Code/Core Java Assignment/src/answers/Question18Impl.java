package answers;

public class Question18Impl extends Question18Abstract {

	public static void main(String[] args) {
		Question18Impl q18 = new Question18Impl();
		
		System.out.println("The string 'Hello' has an upper case char: " + q18.hasUpper("Hello"));
		System.out.println("The string 'hello' has an upper case char: " + q18.hasUpper("hello"));
		System.out.println("The string 'Hello'  to upper case is: " + q18.toUpper("Hello"));
		String str = "hello";
		System.out.println("The integer value of " + str + " is " + q18.stringIntValue(str));	
	}
	@Override
	public boolean hasUpper(String str) {
		char[] charArray = str.toCharArray();
		for (char elem : charArray) {
			if (Character.isUpperCase(elem)) {
				return true;
			}	
		}
		return false;
	}

	@Override
	public String toUpper(String str) {
		return str.toUpperCase();
	}

	@Override
	public int stringIntValue(String str) {
		int value = 0;
		char[] charArray = str.toCharArray();
		
		for (char elem : charArray) {
			value += Character.getNumericValue(elem);
		}
		return value;
	}

}
