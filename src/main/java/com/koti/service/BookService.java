package com.koti.service;

import java.util.List;

import com.koti.entity.Book;

public interface BookService {

	public List<Book> getBooks();
	
	public boolean saveUser(Book book);
	
	public void daleteBook(Integer bookId);
	
	public Book getById(Integer bookId);
	
	
}
