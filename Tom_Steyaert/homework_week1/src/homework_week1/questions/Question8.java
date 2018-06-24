package homework_week1.questions;

import java.util.ArrayList;
import java.util.Arrays;

public class Question8 {

	public static ArrayList<String> getPalindromes(ArrayList<String> input){
		ArrayList<String> palindromes = new ArrayList();

		for(int i = 0 ; i < input.size() ; i++) {
			if(isPalindrome(input.get(i))) {	
				palindromes.add(input.get(i));
			}
		}	
		return palindromes;
	}


	public static boolean isPalindrome(String str) {
		if(str.equals(Question3.reverseString(str))) {
			return true;
		}else {
			return false;
		}
	}

	public static void printArrayList(ArrayList<String> arrayList) {
		for(int i = 0 ; i<arrayList.size() ; i++) {
			System.out.println(arrayList.get(i));
		}
	}

	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList();
		ArrayList<String> palindromes = new ArrayList();

		arrayList.addAll(Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"));
		palindromes=getPalindromes(arrayList);
		printArrayList(palindromes);

	}

}
