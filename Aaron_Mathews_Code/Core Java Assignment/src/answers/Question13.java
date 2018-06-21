package answers;

import java.util.Arrays;

public class Question13 {
	
	public static void main(String[] args) {
		binaryTriangle();
	}
	
	public static void binaryTriangle() {
		int[] binary = new int[10];
		for (int i = 0; i < binary.length; i++) {
			binary[i] = (i % 2 == 0) ? 0 : 1;
		}
		int counter = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(binary[counter]);
				counter++;
			}
			System.out.print("\n");
		}
	}

}
