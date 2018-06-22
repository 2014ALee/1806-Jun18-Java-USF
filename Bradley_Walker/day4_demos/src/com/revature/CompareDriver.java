package com.revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.revature.models.Box;
import com.revature.models.Car;
import com.revature.models.VinComparator;

public class CompareDriver {

	public static void main(String[] args) {
		/*
		 * Comparable interface
		 */
		Box a = new Box(50, "red");
		Box b = new Box(49.5, "blue");
		
		Box[] boxes = {a, new Box(3.5, "black"), b};
		
		for(Box box : boxes)
			System.out.println(box);
		
		System.out.println("---------------------------------------------");
		
		Arrays.sort(boxes);
		
		for(Box box : boxes)
			System.out.println(box);
		
		/*
		 * Comparator interface
		 */
		
		Car myCar = new Car(123, "Nissan", "Rogue", "Grey");
		Car yourCar = new Car(456, "Toyota", "Camry", "Gold");
		
		List<Car> cars = new ArrayList<>();
		cars.add(myCar);
		cars.add(yourCar);
		cars.add(new Car(7, "a", "b", "c"));
		cars.add(new Car(6, "g", "f", "o"));
		
		for(Car car : cars)
			System.out.println(car);
		
		System.out.println("---------------------------------------------");
		
		VinComparator vc = new VinComparator();
		int value = vc.compare(myCar, yourCar);
		System.out.println(value);
		
		cars.sort(vc);
		
		// Same thing
//		Collections.sort(cars, vc);
		
		// Also for arrays
//		Arrays.sort(array, arrayComparator);
	}

}
