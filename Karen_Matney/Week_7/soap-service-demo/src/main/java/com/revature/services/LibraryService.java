package com.revature.services;

import java.util.List;

import javax.jws.WebService;

import com.revature.beans.Book;
import com.revature.exceptions.LibraryFullException;

@WebService
public interface LibraryService {
	List<Book> getAllBooks();
	String add(Book book) throws LibraryFullException;
}
