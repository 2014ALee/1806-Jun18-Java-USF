package homework_week1.questions;

public class Question12 {

	public static void main(String[] args) {

		int[] myArray = new int[100];
		for(int i = 1; i < 101; i++) {
			myArray[i-1] = i;
		}

		for (int i : myArray) {
			if(Question6.isEven(i)) {
				System.out.println(i);
			}
		}


	}

}
