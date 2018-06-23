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
		 */
		
		Box myBox = new Box(50.0, "brown");
		Box yourBox = new Box(45.5, "white");
		
		Box[] boxes = {myBox, new Box(3.5, "black"), yourBox};
		
		for(Box box : boxes) {
			System.out.println(box);
		}
		System.out.println("-------------------------------------------");
		
		Arrays.sort(boxes);
		
		for(Box box : boxes){
			System.out.println(box);
		}
		
		/*
		 * Comparator interface
		 * 
		 * notes to go here
		 */
		
		System.out.println("-------------------------------------------");
		
		Car myCar = new Car(12345678, "Nissan", "Rouge","grey");
		Car yourCar = new Car(98765444, "Toyata", "Camry", "gold");
		
		List<Car> cars = new ArrayList<>();
		cars.add(myCar);
		cars.add(yourCar);
		cars.add(new Car(2342, "Ford", "Tarus,", "white"));
		cars.add(new Car(34536634, "Chevrolet", "S-10", "black"));
		
		for(Car car: cars)
			System.out.println(car);
		
		System.out.println("-------------------------------------------");
		
		VinComparator vinComparator = new VinComparator();
		int value = vinComparator.compare(myCar, yourCar);
		System.out.println(value);
		
		cars.sort(vinComparator);
		for(Car car: cars)
			System.out.println(car);
	}
	
}
