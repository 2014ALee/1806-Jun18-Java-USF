package question10;

public class TernaryOp {
	
	public static void main (String[] args) {
	
	//prog. uses a ternary operator to find min value of 2 numbers
	
	/*
	 * also known as an conditional operator. it is an 
	 * alternative to the if then else statements. 
	 * 
	 * syntax:
	 * 
	 * result= test conditions ? value 1 : value 2
	 * 
	 * if test conditions true, assign val 1 to the result, 
	 * otherwise assign val 2.
	 */
	
	double  a=0.0;
	double b=1.0;
	double minVal;
	

	double minVal1= (a<b) ? a:b;
			
	System.out.println(minVal1);
	
	
}
}