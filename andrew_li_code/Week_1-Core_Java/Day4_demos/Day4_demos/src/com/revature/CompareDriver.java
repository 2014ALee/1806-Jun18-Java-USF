package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Car;
import com.revature.models.VinComparator;

public class CompareDriver {
	public static void main(String[] args) {
		Car myCar = new Car(12345678, "Nissan", "Rogue", "grey");
		Car yourCar = new Car(987654321, "Toyota", "Camry", "gold");
		
		List<Car> cars = new ArrayList<Car>();
		
		cars.add(myCar);
		cars.add(yourCar);
		cars.add(new Car(2342, "Ford", "Taurus", "white"));
		
		System.out.println("______________________________________________\n");
		VinComparator vinComparator = new VinComparator();
		int value = vinComparator.compare(myCar, yourCar);
		System.out.println(value);
		cars.sort(vinComparator);
		System.out.println(cars);
		
	}
}
