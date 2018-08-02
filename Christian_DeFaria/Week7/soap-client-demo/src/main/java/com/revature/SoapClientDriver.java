package com.revature;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.beans.Book;
import com.revature.services.LibraryService;

public class SoapClientDriver {
	
	private static final String serviceUrl = "http://localhost:9999/soap-service-demo/library";
	
	public static void main(String[] args) {
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(LibraryService.class);
		factory.setAddress(serviceUrl);
		
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
		
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		
		LibraryService library = (LibraryService) factory.create();
		
		System.out.println("[DEBUG] - LibraryService.getAllBooks");
		List<Book> books = library.getAllBooks();
		for(Book b : books) {
			System.out.println(b);
		}
		
		System.out.println("[DEBUG] - LibraryService.addBook");
		Book b = new Book("Choke", "Chuck Palahniuk", 2001);
		
		try {
			System.out.println("Attempting to add: " + b.getTitle());
			System.out.println(library.addBook(b));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[DEBUG] - LibraryService.addBook");
		b = new Book("Twilight", "Stephanie Meyer", 2005);
		
		try {
			System.out.println("Attempting to add: " + b.getTitle());
			System.out.println(library.addBook(b));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
//		System.out.println("Attempting to invoke LibraryService.notRealMethod");
//		library.notRealMethod();
		
	}

}
