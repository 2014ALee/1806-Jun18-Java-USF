package com.revature.services;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class ClientDriver {
	
	public static void main(String[] args) {
		
		try {
			DealershipService service = new DealershipServiceImplServiceLocator().getDealershipServiceImplPort();
			Car[] cars = service.getAllCars();
			
			for(Car car : cars) {
				System.out.println(car);
			}
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
