package com.revature.services;

import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Car;

@WebService
public interface DealershipService {

	List<Car> getAllCars();

	String addCar(Car car);
}
