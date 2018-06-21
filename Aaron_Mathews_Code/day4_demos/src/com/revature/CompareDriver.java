package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.revature.models.VinComparator;

import com.revature.models.Box;
import com.revature.models.Car;

public class CompareDriver {
	
	public static void main(String[] args) {
		/*
		 * Comparable Interface
		 * 
		 * - Provided by java in any custom class to use sorting of Arrays or Collection
		 */
		Box myBox = new Box(50.0, "brown");
		Box yourBox = new Box(45.5, "white");
		
		Box[] boxes = {myBox, new Box(3.5, "black"), yourBox};
		
		for ( Box box : boxes) {
			System.out.println(box);
		}
		
		System.out.println("----------------------");
		
		Arrays.sort(boxes);
		for ( Box box : boxes) {
			System.out.println(box);
		}
		
		/*
		 * Comparator Interface
		 * 
		 * - Also used from comparison
		 * - Comparable is a property of the object
		 * - Comparator is a separate object that compares
		 */
		
		Car myCar = new Car(12343245, "Nissan", "Rogue", "gray");
		Car yourCar = new Car(12341234, "Toyota", "Camry", "gold");
		
		List<Car> cars = new ArrayList<>();
		cars.add(myCar);
		cars.add(yourCar);
		cars.add(new Car(21234, "Ford", "Torus", "White"));
		cars.add(new Car(234, "Chevy", "S10", "black"));
		
		for (Car car : cars) {
			System.out.println(car);
		}
		
		System.out.println("----------------------");
		System.out.println("----------------------");
		
		VinComparator vinComparator = new VinComparator();
		
		int value = vinComparator.compare(myCar, yourCar);
		System.out.println(value);
		
		cars.sort(vinComparator);
		
		for (Car car : cars) {
			System.out.println(car);
		}
	}

}
