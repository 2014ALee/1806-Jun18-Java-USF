package answers;

public class Question12 {
	
	public static void main(String[] args) {
		evenArray();
	}
	
	public static void evenArray() {
		int[] numberArray = new int[100];
		for (int i = 0; i < numberArray.length; i++) {
			numberArray[i] = i + 1;
		}
		for (int num : numberArray) {
			if (num % 2 == 0) {
				System.out.println(num);
			}
		}
	}

}
