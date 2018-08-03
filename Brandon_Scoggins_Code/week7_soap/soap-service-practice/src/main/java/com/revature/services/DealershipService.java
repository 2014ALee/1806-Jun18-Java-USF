package com.revature.services;

import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Car;
import com.revature.exceptions.LotFullException;

@WebService
public interface DealershipService {

	List<Car> getAllCars();
	String addCar(Car car) throws LotFullException;
}
