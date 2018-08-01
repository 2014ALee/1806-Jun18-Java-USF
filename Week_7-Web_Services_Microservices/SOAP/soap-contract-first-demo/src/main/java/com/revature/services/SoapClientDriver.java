package com.revature.services;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class SoapClientDriver {
	
	public static void main(String[] args) {
		
		try {
			LibraryService service = new LibraryServiceImplServiceLocator().getLibraryServiceImplPort();
			Book[] bookList = service.getAllBooks();
			
			for(Book book : bookList) {
				System.out.println(book);
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
