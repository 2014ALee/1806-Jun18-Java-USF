package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Car;
import com.revature.exceptions.LotFullException;

@WebService(endpointInterface="com.revature.services.DealershipService")
public class DealershipServiceImpl implements DealershipService{

	private static List<Car> carList = new ArrayList<>();
	
	@Override
	public List<Car> getAllCars() {
		carList.add(new Car("Toyota", "Corolla", 2012, "Gold"));
		carList.add(new Car("Ford", "Focus", 2014, "Red"));
		carList.add(new Car("Honda", "Accord", 2018, "Black"));
		carList.add(new Car("Hyndai", "Sonata", 2017, "Blue"));
		return carList;
	}

	@Override
	public String addCar(Car car) throws LotFullException {
		if (car.getYear() < 2010) {
			throw new LotFullException("Sorry. Lot is full..");
		} else {
			carList.add(car);
		}
		return car.getMake() + " " + car.getModel() + " was added to the lot.";
	}

}
