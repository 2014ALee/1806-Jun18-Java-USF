package answers;

import java.util.Calendar;

public class Question14 {
	// Some miscellaneous stuff

	public static void main(String[] args) {
		int x = 2;
		
		switch(x) {
		case 1:
			System.out.println("Square Root of 5 is" + Math.sqrt(5));
			break;
		case 2:
			Calendar today = Calendar.getInstance();
			today.set(Calendar.HOUR_OF_DAY, 0);
			today.set(Calendar.MINUTE, 0);
			today.set(Calendar.SECOND, 0);
			System.out.println(today.getTime());
			break;
		case 3:
			String str = "I am learning Core Java";
			String[] chars = str.split("");
			break;
		default:
			System.out.println("Hi there");
		}
	}

}
