package day2_demos;

public class warm_ups {
	public static void main(String[] args) {
		
		int a = 1;
		int b = 2;
		a = b + a++;
		System.out.println(a);
		/*
		 * 1: Replace b with 2.
		 * a = 2 + a++;
		 * 
		 * 2: Replace a++ with 1
		 * a = 2 + 1;
		 * 
		 * 3: Increment a by 1, a = 2
		 * a = 2 + 1;
		 * 
		 * 4: Find the sum
		 * a = 3;
		 * 
		 * 5: Print 
		 * 3
		 */
		
		int x = 10;
		System.out.println(x++ * ++x * x++);
		System.out.println(x);
	}

}
