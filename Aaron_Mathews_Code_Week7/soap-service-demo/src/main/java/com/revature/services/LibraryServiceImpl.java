package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Book;
import com.revature.exceptions.LibraryFullException;

@WebService(endpointInterface="com.revature.services.LibraryService")
public class LibraryServiceImpl implements LibraryService {

	private static List<Book> bookList = new ArrayList<>();
	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("The Gunslinger", "Stephen King" ,1982));
		bookList.add(new Book("Slaughterhouse-Five","Kurt Vonnegut",1969));
		return bookList;
	}

	@Override
	public String addBook(Book book) throws LibraryFullException {
		if (book.getTitle().equals("Twilight")) {
			throw new LibraryFullException("Library full. Cannot add " + book.getTitle());
		} else {
			bookList.add(book);
			return "Succesfully added " + book.getTitle() + "by " + book.getAuthor();
		}
	}

}
