package com.revature.models;

import java.util.Comparator;

public class VinComparator implements Comparator<Car> {

	@Override
	public int compare(Car car1, Car car2) {
		int number = car1.getVin() - car2.getVin();
		if (number > 0) {
			return 1;
		}
		else if (number < 0) {
			return -1;
		}
		return 0;
	}

}
