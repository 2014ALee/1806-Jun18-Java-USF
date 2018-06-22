package com.revature;

import java.util.ArrayList;
import java.util.List;
import com.revature.models.Car;
import com.revature.models.VinComparator;

public class compareDriver {

	/*
	 * comparable interface
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * comparator interface
	 * 
	 */
	
	
	private void main() {
		
		Car myCar = new Car(122234234, "Nissan", "Rogue", "grey");
		Car yourCar = new Car(9912391, "Toyota", "Camry", "gold");
		
		List<Car> cars = new ArrayList<>();
		cars.add(myCar);
		cars.add(yourCar);
		cars.add(new Car(123123, "Ford", "Taurus", "white"));
		cars.add(new Car(43123123, "Chevy", "S-10", "black"));
		
		for(Car car : cars) {
			System.out.println(car);
		}

		VinComparator vinComparator = new VinComparator();
		
		
	}
	
}
