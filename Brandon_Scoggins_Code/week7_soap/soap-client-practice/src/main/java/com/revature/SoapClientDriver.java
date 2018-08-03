package com.revature;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.beans.Car;
import com.revature.services.DealershipService;

public class SoapClientDriver {

	private static final String SERVICE_URL = "http://soap-dealership-service.us-east-2.elasticbeanstalk.com/dealership";

	public static void main(String[] args) {
		// Set up factory to create service
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(DealershipService.class);
		factory.setAddress(SERVICE_URL);

		// set up interceptors to log incoming and out going messages
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();

		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));

		// Add in/out interceptros to factory
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);

		// Create instance of dealership service using the implementation provided
		// through the SOAP service
		DealershipService dealership = (DealershipService) factory.create();

		// test out our service operations
		System.out.println("[DEBUG] - DealershipService.getAllCars()");
		List<Car> carList = dealership.getAllCars();
		for (Car car : carList) {
			System.out.println(car);
		}

		System.out.println("[DEBUG] - DealershipService.addCar() {'2001 Toyota'}");
		Car car = new Car("Toyota", "Camry", 2001, "Red");

		try {
			System.out.println(dealership.addCar(car));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("[DEBUG] - DealershipService.addCar() {'2012 Jeep Cherokee'}");
		car = new Car("Jeep", "Cherokee", 2012, "Grey");

		try {
			System.out.println(dealership.addCar(car));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// -------------------------------------------------------------------------------

		// System.out.println("Attempting to invoke
		// DealershipService.notRealMethod()...");
		// dealership.notRealMethod();
	}
}