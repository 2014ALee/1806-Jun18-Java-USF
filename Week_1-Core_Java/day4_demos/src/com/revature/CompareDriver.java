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
		 * Java provides Comparable interface which should be implemented by any custom class if we want to use 
		 * Arrays or Collections sorting methods. Comparable interface has compareTo(T obj) method which is used 
		 * by sorting methods, you can check any Wrapper, String or Date class to confirm this. We should override 
		 * this method in such a way that it returns a negative integer, zero, or a positive integer if “this” 
		 * object is less than, equal to, or greater than the object passed as argument.
		 */
		Box myBox = new Box(50.0, "brown");
		Box yourBox = new Box(45.5, "white");
		
		Box[] boxes = { myBox, new Box(3.5, "black"), yourBox };
		
		for(Box box : boxes) {
			System.out.println(box);
		}
		
		System.out.println("+---------------------------------------+");
		
		Arrays.sort(boxes);
		
		for(Box box : boxes) {
			System.out.println(box);
		}
		
		System.out.println("+----------------------------------------+");
		
		/*
		 * Comparator interface
		 * 
		 * Comparator interface compare(Object o1, Object o2) method need to be implemented that takes two Object 
		 * argument, it should be implemented in such a way that it returns negative int if first argument is less 
		 * than the second one and returns zero if they are equal and positive int if first argument is greater 
		 * than second one.
		 */
		Car myCar = new Car(12345678, "Nissan", "Rogue", "grey");
		Car yourCar = new Car(98765444, "Toyota", "Camry", "gold");
		
		List<Car> cars = new ArrayList<>();
		cars.add(myCar);
		cars.add(yourCar);
		cars.add(new Car(2342, "Ford", "Taurus", "white"));
		cars.add(new Car(34536634, "Chevrolet", "S-10", "black"));
		
		for(Car car: cars) {
			System.out.println(car);
		}
		
		System.out.println("+----------------------------------------+");
		
		VinComparator vinComparator = new VinComparator();
		int value = vinComparator.compare(myCar, yourCar);
		System.out.println(value);
		
		cars.sort(vinComparator);
		
		for(Car car: cars) {
			System.out.println(car);
		}
	}
}
