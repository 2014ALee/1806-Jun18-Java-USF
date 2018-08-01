/**
 * LibraryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.revature.services;

public interface LibraryService extends java.rmi.Remote {
    public java.lang.String addBook(com.revature.services.Book arg0) throws java.rmi.RemoteException, com.revature.services.LibraryFullException;
    public com.revature.services.Book[] getAllBooks() throws java.rmi.RemoteException;
}
