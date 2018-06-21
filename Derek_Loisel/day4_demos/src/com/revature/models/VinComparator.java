package com.revature.models;

import java.util.Comparator;
import com.revature.models.Car;

public class VinComparator implements Comparator<Car> { 

	
	@Override
	public int compare(Car car1, Car car2) {
		
		if (car1.getVin() - car2.getVin() > 0){
			return 1;	
		}else if (car1.getVin() - car2.getVin() < 0) {
			return -1;
		}else {
			
		return 0;
		}
	}
	

}
