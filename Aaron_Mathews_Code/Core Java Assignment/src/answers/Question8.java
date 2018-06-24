package answers;

import java.util.ArrayList;

public class Question8 {
	static ArrayList<String> strList = new ArrayList<>();
	static ArrayList<String> paliList = new ArrayList<>();

	public static void main(String[] args) {
		String[] strArr = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
		for (String str : strArr) {
			strList.add(str);
		}
		System.out.println(strList);
		System.out.println(sortPali(strList));
	}
	
	public static ArrayList<String> sortPali(ArrayList<String> strList) {
		for (String str : strList) {
			boolean pali = checkPali(str);
			if (pali) {
				paliList.add(str);
			}
		}
		return paliList;
	}
	
	public static boolean checkPali(String str) {
		
		boolean isPali = false;
		if (str.toLowerCase().equals(reverseString(str).toLowerCase())) {
			isPali = true;
		}
		return isPali;
	}
	
	public static String reverseString(String str) {
		for (char myChar : str.toCharArray()) {
			str = myChar + str;
		}
		str = str.substring(0, str.length() / 2);
		return str;
	}
}
