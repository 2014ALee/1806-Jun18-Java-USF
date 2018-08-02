package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.exceptions.LibraryFullException;
import com.revature.models.Book;

@WebService(endpointInterface="com.revature.services.LibraryService")
public class LibraryServiceImpl implements LibraryService {
	
	private static List<Book> books = new ArrayList<>();

	@Override
	public List<Book> getAllBooks() {
		books.add(new Book("The Gunslinger", "Stephen King", 1982));
		books.add(new Book("Slaughterhouse-Five", "Kurt Vonnegut", 1969));
		books.add(new Book("Brave New World", "Aldous Huxley", 1931));
		return books;
	}

	@Override
	public String addBook(Book b) throws LibraryFullException {
		if(b.getTitle().equals("Twilight")) {
			throw new LibraryFullException("Library full. Cannot add " + b.getTitle());
		} else {
			books.add(b);
		}
		return "Successfully added " + b.getTitle() + " by " + b.getAuthor();
	}

}
