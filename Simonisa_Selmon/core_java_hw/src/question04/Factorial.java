package question04;

/*
 * this program will the compute the factorial of n or n!. 
 * 
 * if you recall, the factorial of a # is simply the the product of all 
 * natural #'s up to its point. 
 * 
 * So 6!= 1*2*3*4*5*6= 720.
 */

public class Factorial {

	public static void main(String[] args) {
		
		int n= 6;
		int r= 1;
		
		for (int i=1; i<=n; i++) {
			r= r*i;
			
		}
System.out.println("6! = " + r);
	}

}
/*So what have we done here:
 * 
 * n is the number whose factorial we want to compute via loop
 * 
 * And I know I want to iterate from 1-->6, sure not to pass 6
 * therefore I created a forloop that establishes my initial
 * start point, for every integer between it and my number n
 * and increment.
 * 
 * I also know that I will be printing an output and I 
 * will need to concatenate a variable.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
