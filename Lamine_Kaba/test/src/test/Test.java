package test;

import java.text.DecimalFormat;

public class Test {
	private static DecimalFormat df2 = new DecimalFormat(".##");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 10;
		
		//System.out.println(x++ * ++x * x++);
		
		double x2 = 2.4745;
		String x3;
		
		x3 = new DecimalFormat("#.00").format(x2);
		
		System.out.println("x3 string value is:");
		System.out.println(x3);
		
		// Change x3 back to double
		double x4;
		x4 = Double.parseDouble(x3);
		System.out.println("x4 after parsing is:");
		System.out.println(x4);
		
		// Add value to x4
		x4 = x4 + 5;
		System.out.println("x4 + 5 is:");
		System.out.println(x4);		
		
		/*
		 * DecimalFormat df = new DecimalFormat("#.00"); 
			Note the "00", meaning exactly two decimal places.
			If you use "#.##" (# means "optional" digit), it will drop trailing zeroes - ie new DecimalFormat("#.##").format(3.0d);
 			prints just "3", not "3.00"
		 */
		
		
	}
	
	
//	public static double trimp() {
//		
//		double x2 = 2.4745;
//		
//		return df2.format(x2);
//		
//	}
	
	
}

/*
 * JDV -> JRE -> JVM
 * JVM = Java Virtual Machine
 * Change ButeCode to Machine Lang
 * Lives in the JRE
 * 
 * JRE = Java Runtime Env
 * A Collection of jar file/ libraries
 * needed to run all java apps
 * Contains the JVM
 * 
 * JDK = Java Development Kit
 * Javac (Compliler)
 * Contains the JRE
 */

/*
 * AutoBoxing is using primitive class to declare a variable
 * Integer X = 5;
 * Unboxing is using the short name as type of a variable
 * Int x = 5;
 */

/*
 * Clases vs Object?
 * 
 * Class is blue print or template that define the sates(fields) and behaviors(
 * methods) of an object.
 * Object is an instance of the class
 */

/*
 * Methods vs Function
 * Methods live in classes and Function do not
 */
/* Packages vs Imports
 * package are groupings of code file related functionality
 * imports are used to make other classes usable with in a package
 */
/*
 * Variable declarations vs initializations
 * int x; (declaration)
 * x=0; (initialization)
 * x=1; (re-assignment)
 */

/*Instance vs Class members
 * Class members are static
 * Instance members are non-static
 */










