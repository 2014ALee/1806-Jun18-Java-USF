package com.revature.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BOOK_INFO")
public class BookInfo {

	@Column(name="isbn")
	private String isbn;
	
	@EmbeddedId
	private BookInfoId id;
	
	public BookInfo() { }

	public BookInfo(String isbn, BookInfoId id) {
		super();
		this.isbn = isbn;
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BookInfoId getId() {
		return id;
	}

	public void setId(BookInfoId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BookInfo [isbn=" + isbn + ", id=" + id + "]";
	}	
	
}
