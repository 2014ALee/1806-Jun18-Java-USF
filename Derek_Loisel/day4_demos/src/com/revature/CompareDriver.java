package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.models.Box;
import com.revature.models.Car;
import com.revature.models.VinComparator;

public class CompareDriver {

	/*
	 * comparable interface - should be implemented in any custom class we make when we want the sorting funcitonality from the arrays or collections
	 * comparable is used as a method in your custom objects, comparator is an object that compares things
	 */
	public static void main(String[] args) {
		
		Box myBox = new Box (50.0, "brown");
		Box yourBox = new Box (45.5, "white");
		
		Box[] boxes = {myBox, new Box(3.5, "black"), yourBox} ;
		
		//prints boxes before its sorted
		for(Box box : boxes) {
			System.out.println(box);
		}
			
			Arrays.sort(boxes);
			for(Box box : boxes) {
				System.out.println(box);
			}
			
			
			
			/*
			 * comparator interface
			 */
			
			Car myCar = new Car(1234, "nissan","rogue","grey");
			Car yourCar = new Car(12342234, "nissano","roguey","greyeth");
			
			List<Car> cars = new ArrayList<>();
			cars.add(myCar);
			cars.add(yourCar);
			
			//print before sort
			for(Car car:cars) {
				System.out.println(car);
			}
			
			System.out.println("------------------------------------------");
			
			VinComparator vinComparator = new VinComparator();
			
			int value = VinComparator.compare(myCar, yourCar);
			
			System.out.println(value);
			
			cars.sort(vinComparator);
			//print after sort
			for(Car car:cars) {
				System.out.println(car);
			}
	}
	
	
	
}
