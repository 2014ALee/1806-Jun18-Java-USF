package com.revature.services;

import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Book;

@WebService
public interface LibraryService {
	
	List<Book> getAllBooks();
	String addBook(Book book);
	void notRealMethod();

}
