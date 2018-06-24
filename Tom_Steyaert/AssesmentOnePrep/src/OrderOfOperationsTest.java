
public class OrderOfOperationsTest {

	public static void main(String[] args) {

		int i=1;
		
		//we increment after the print
		System.out.println(i++);
		
		//it prints the incremented value
		System.out.println(i);
		
		System.out.println(++i);
		System.out.println(i);

		int x = 5;
		int y = 10;	
		/*
		 * z = ++x * y--;
		 * z = ++5 * 10--
		 * z = 6 * 10
		 * x is already equal to 6
		 * y--; (y = 9)
		 * z = 60
		 */
		int z = ++x * y--;
//		System.out.println(z);

boolean bool = true;

int value = bool ? 1:2;

		System.out.println("1 + 2 = " + 1 * 2);
		System.out.println("1 + 2 = " + (1 + 2));
		int year=14;

		  boolean a = (((year % 4) == 0) && ((year % 100) != 0)) || ((year % 400) == 0);
		  boolean b = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	        boolean c = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	        boolean d = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	        boolean e = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
	        System.out.println(a);
	        System.out.println(b);
	        System.out.println(c);
	        System.out.println(d);
	        System.out.println(e);
		
		
	}
	
	
}
