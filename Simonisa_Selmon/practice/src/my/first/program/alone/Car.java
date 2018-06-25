package my.first.program.alone;
import java.awt.*;

public class Car {
	
	Color color;
	String model;
	int year;
	boolean sunroof;
	/*this above is my class/blueprint for the car that I want to create. But 
	 * remember, in order to instantiate an object you need to construct it first. Think
	 * about real life. A car has to be built in order for it to be considered a car,
	 * which I can then but off the lot and take home with me. The above are like
	 * parameters for me in order to pick the car I'm satisfied with.
	 */
	
	public Car( Color myCarColor, String myCarModel, int myCarYear, boolean isThereASunroof) {
		/*when we construct the car with our constructors later, we will pass-through 
		 * these values into the variables above.
		 */
		this.color= myCarColor;
		this.model= myCarModel;
		this.year= myCarYear;
		this.sunroof= isThereASunroof;
		/*
		 * The "this"keyword allows us to initialize our variables so that they become objects!
		 * therefore, it makes sense that I can use the same name/color for my car
		 * 
		 * When we go on to construct our object. They constructor will automatically 
		 * call to these 
		 */
		
	}
}




