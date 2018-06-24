package homework_week1.questions;

public class Question12 {

	public static void main(String[] args) {

		//we populate our array with the numbers 1 to 100
		int[] myArray = new int[100];
		for(int i = 1; i < 101; i++) {
			myArray[i-1] = i;
		}

		//the enhanced for loop below prints out the array's element at i if it's an even number
		for (int i : myArray) {
			if(Question6.isEven(i)) {
				System.out.println(i);
			}
		}
	}
}
