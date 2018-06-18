package come.revature.models;

/*
 * This is a  class. A class is a blueprint, or a template, from which objects are created.
 * Classes can contain variables, methods, and nested classes - which are all collectively
 * kown as the 'members' of the class.
 * 
 * If no parent class is explicitly extended, then the Object class is implicitly extended.
 */

public class Person {

	//Instance variables
	public String firstName = "John";
	public String lastName = "Sample";
	public int age_yrs = 35;
	public double height_in = 72.0;
	public double weigth_lbs = 180;
	
	//class variables
	public static final boolean IS_HUMAN = true;
	public static int someValue;
	
	/*
	 * Constructors
	 */
	public Person() {
		
	}
	public Person(String firstName) {
		this.firstName = firstName;
	}
	
	public double calculateBMI() {
		return (this.weigth_lbs / this.height_in/this.height_in)*703;
	}
	
	public static void eat() {
		System.out.println("the person is eating.");
	}
	
}
