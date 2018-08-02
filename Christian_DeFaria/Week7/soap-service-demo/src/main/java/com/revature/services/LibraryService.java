package com.revature.services;

import java.util.List;

import javax.jws.WebService;

import com.revature.exceptions.LibraryFullException;
import com.revature.models.Book;

@WebService
public interface LibraryService {
	
	List<Book> getAllBooks();
	String addBook(Book b) throws LibraryFullException;

}
