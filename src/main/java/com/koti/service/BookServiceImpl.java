package com.koti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koti.entity.Book;
import com.koti.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo repo;
	
	@Override
	public List<Book> getBooks() {
		
		return repo.findByActiveSW("Y");
		
	}

	@Override
	public boolean saveUser(Book book) {
		book.setActiveSW("Y");
		Book save = repo.save(book);
		
		if(save.getBookId()!=null) return true;
		else return false;
		
	}
	@Override
	public void daleteBook(Integer bookId) {
		
		//Hard Delete
//		repo.deleteById(bookId);
		
		//Soft Delete
		
		Optional<Book> bookByid = repo.findById(bookId);
		if(bookByid.isPresent())
		{
			Book book = bookByid.get();
			book.setActiveSW("N");
			repo.save(book);
		}
		
	}
	@Override
	public Book getById(Integer bookId) {
		
		Optional<Book> byId = repo.findById(bookId);
		if(byId.isPresent())
		{
			return byId.get();
		}
		return null;
		


	}

}
