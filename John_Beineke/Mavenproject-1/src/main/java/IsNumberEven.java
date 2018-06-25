import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class IsNumberEven {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number to see if it is even: ");
		int num = input.nextInt();
		
		testEven(num);
	}
	
	private static void testEven(int n) {
		if ((n % 2) == 0) {
			System.out.println("The number is even!");
			return;
		}
		else {
			System.out.println("The number is not even...");
			return;
		}
	}

}
