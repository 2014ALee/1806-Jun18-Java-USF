package answers;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Question14 {
	// Switch statement

	public static void main(String[] args) {
		System.out.println(getString(1));
	}
	
	public static String getString(int i) {
		switch(i) {
		case 1:
			return "" + Math.sqrt(64);
		case 2:
			Calendar today = Calendar.getInstance();
			today.set(Calendar.HOUR_OF_DAY, 0);
			today.set(Calendar.MINUTE, 0);
			today.set(Calendar.SECOND, 0);
			return today.getTime().toString();
		case 3:
			String str = "I am learning Core Java";
			String[] words = str.split(" ");
			return words[0];
		default:
			return "default";
		}
	}
}
