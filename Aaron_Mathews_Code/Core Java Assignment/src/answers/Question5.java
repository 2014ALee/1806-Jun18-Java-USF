package answers;

public class Question5 {
	
	public static void main(String[] args) {
		System.out.println(substring("hello", 3));
	}
	
	public static String substring(String str, int idx) {
		char[] charArray = new char[idx];
		for (int i = 0; i < idx; i++) {
			charArray[i] = str.charAt(i);
		}
		return String.valueOf(charArray);
	}

}
