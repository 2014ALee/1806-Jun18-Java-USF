package homework_week1.questions;

public class Question6 {

	public static boolean isEven(int input) {
		
		//if our input isn't even, we will lose the remainder when doing integer division.
		//so, the divided number multiplied by two won't be the original number since we
		//lost information
		int newValue = (input / 2) * 2;
		if(newValue == input) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {

	}

}
