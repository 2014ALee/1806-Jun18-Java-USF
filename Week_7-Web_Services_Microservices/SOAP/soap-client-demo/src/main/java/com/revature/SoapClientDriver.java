package com.revature;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.beans.Book;
import com.revature.services.LibraryService;

public class SoapClientDriver {
	
	private static final String SERVICE_URL = "http://localhost:8080/soap-service-demo/library";
	
	public static void main(String[] args) {
		
		// Set up our factory to create our service
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(LibraryService.class);
		factory.setAddress(SERVICE_URL);
		
		// Set up interceptors to log our incoming and outgoing messages
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
		
		// Add in/out interceptors to factory
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		
		// Create an instance of the LibraryService using the implementation provided through the SOAP service
		LibraryService library = (LibraryService) factory.create();
		
		// Test out our service operations
		System.out.println("[DEBUG] - LibraryService.getAllBooks()...");
		List<Book> bookList = library.getAllBooks();
		for(Book book : bookList) {
			System.out.println(book);
		}
		
		System.out.println("[DEBUG] - LibraryService.addBook()...");
		Book book = new Book("Choke", "Chuck Palahniuk", 2001);
		
		try {
			System.out.println("Attempting to add book: " + book.getTitle());
			System.out.println(library.addBook(book));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//------------------------------------------------------------------------
		
		System.out.println("[DEBUG] - LibraryService.addBook()...");
		book = new Book("Twilight", "Stephanie Meyer", 2005);
		
		try {
			System.out.println("Attempting to add book: " + book.getTitle());
			System.out.println(library.addBook(book));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//------------------------------------------------------------------------
		
//		System.out.println("Attempting to invoke LibraryService.notRealMethod()...");
//		library.notRealMethod();
		
	}

}
