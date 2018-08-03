/**
 * DealershipService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.revature.services;

public interface DealershipService extends java.rmi.Remote {
    public java.lang.String addCar(com.revature.services.Car arg0) throws java.rmi.RemoteException, com.revature.services.LotFullException;
    public com.revature.services.Car[] getAllCars() throws java.rmi.RemoteException;
}
