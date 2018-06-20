package answers;

public class Question5 {
	// Substring method. (reinventing the wheel)

	public static void main(String[] args) {
		String string = "12345";
		int num = 5;
		String result = subString(string, num);
		System.out.println(result);
	}

	public static String subString(String str, int idx) {
		char[] chars = str.toCharArray();
		char[] result = new char[chars.length];
		for(int i = 0; i < idx; i++)
			result[i] = chars[i];
		return new String(result);
	}
	
}
