package answers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question18Concrete extends Question18Abstract {
	private static List<String> upperCaseLetters = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
	
	public static void main(String[] args) {
		Question18Concrete q18 = new Question18Concrete();
		System.out.println(q18.containsUppercase("Test"));
		System.out.println(q18.toUpperCase("This is a test string()_!@"));
		System.out.println(q18.toInt("15"));
	}

	@Override
	public boolean containsUppercase(String str) {		
		String[] chars = str.split("");
		for(String s : chars)
			if(upperCaseLetters.contains(s))
				return true;
		return false;
	}

	@Override
	public String toUpperCase(String str) {
		String result = "";
		for(String s : str.split(""))
			if(upperCaseLetters.contains(s.toUpperCase()))
				result += upperCaseLetters.get(upperCaseLetters.indexOf(s.toUpperCase()));
			else
				result += s;
		return result;
	}

	@Override
	public int toInt(String str) {
		try {
			int num = Integer.parseInt(str);
			num += 10;
			return num;
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return 0;
	}

}
