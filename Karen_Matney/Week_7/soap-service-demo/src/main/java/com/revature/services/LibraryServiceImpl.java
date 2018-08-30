package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Book;
import com.revature.exceptions.LibraryFullException;

// TODO: Following note put elsewhere
// PortType is the interface, Binding is the implementation

@WebService(endpointInterface="com.revature.services.LibraryService")
public class LibraryServiceImpl implements LibraryService {
	private static List<Book> bookList = new ArrayList<>();
	
	static  {
		bookList.add(new Book("The Gunslinger","Stephen King",1982));
		bookList.add(new Book("Slaughterhouse-Five","Kurt Vonnegut",1969));
		bookList.add(new Book("Brave New World","Aldous Huxley",1));
		
	}

	@Override
	public List<Book> getAllBooks() {
		return bookList;
	}

	@Override
	public String add(Book book) throws LibraryFullException {
		if(book.getTitle().equals("Twilight")) {
			throw new LibraryFullException("Library full. Cannot add " + book.getTitle());
		}
		bookList.add(book);
		
		return "Successfully added " + book.getTitle() + " by " + book.getAuthor();
	}

}
