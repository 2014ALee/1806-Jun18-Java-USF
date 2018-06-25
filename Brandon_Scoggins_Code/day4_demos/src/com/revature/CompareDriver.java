package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.models.Box;
import com.revature.models.Car;
import com.revature.models.VinComparator;

public class CompareDriver {

	public static void main(String[] args) {
		
		/*
		 * Comparable interface
		 * 
		 * notes
		 */
		
		Box myBox = new Box(50.0, "brown");
		Box yourBox = new Box(45.5, "white");
		
		Box[] boxes = {myBox, new Box(3.5, "black"), yourBox};
		
		for(Box box : boxes)
			System.out.println(box);
		
		System.out.println("------------------------------------------------");
		
		Arrays.sort(boxes);
		
		for(Box box : boxes)
			System.out.println(box);

		System.out.println("------------------------------------------------");
		System.out.println("------------------------------------------------");
		
		/*
		 * Comparator interface
		 * 
		 * notes
		 */
		
		Car myCar = new Car(123_456_78, "Nissan", "Rogue", "grey");
		Car yourCar = new Car(345_654_33, "Toyota", "Camry", "gold");
		
		List<Car> cars = new ArrayList<>();
		cars.add(myCar);
		cars.add(yourCar);
		cars.add(new Car(758_853_53, "Ford", "Ranger", "red"));
		cars.add(new Car(834_573_93, "Honda", "Accord", "white"));
		
		for(Car car : cars)
			System.out.println(car);
		
		System.out.println("------------------------------------------------");
		
		VinComparator vinComparator = new VinComparator();
		int value = vinComparator.compare(myCar, yourCar);
		System.out.println(value);
		
		cars.sort(vinComparator);
				
		for(Car car : cars)
			System.out.println(car);
		
		
		
		
		
		
		
		
		
		
		
	}
}
