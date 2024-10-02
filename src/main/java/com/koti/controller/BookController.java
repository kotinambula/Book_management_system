package com.koti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.koti.entity.Book;
import com.koti.service.BookServiceImpl;

import jakarta.websocket.server.PathParam;

@Controller
public class BookController {

	@Autowired
	private BookServiceImpl service;
	
	@GetMapping("/add")
	public ModelAndView index()
	{
		ModelAndView mav = new ModelAndView();
		// sending empty obj for form binding
		mav.addObject("book",new Book());
		mav.setViewName("add");
		return mav;
	}
	
	@PostMapping("/book")
	public ModelAndView saveBook(Book book)
	{
		ModelAndView mav = new ModelAndView();
		boolean saveUser = service.saveUser(book);
		if(saveUser) {
			mav.addObject("succMsg","Book added successfully");
		}
		else
		{
			mav.addObject("errMsg","Invalid data");
		}
		mav.setViewName("add");
		return mav;
		
	}

	@GetMapping("/books")
	public ModelAndView getBooks()
	{
		ModelAndView mav = new ModelAndView();
		List<Book> books = service.getBooks();
		mav.addObject("books",books);
		mav.setViewName("books");
		return mav;
	}
	
	
	@GetMapping("/delete")
	public ModelAndView deleteBookById(@PathParam("bookId")  Integer bookId)
	{

		service.daleteBook(bookId);
		ModelAndView mav = new ModelAndView();
		List<Book> books = service.getBooks();
		mav.addObject("books", books);
		mav.setViewName("books");
		return mav;

	}
	
	@GetMapping("/edit")
	public ModelAndView getBookById(@RequestParam("bookId") Integer bookId)
	{
		ModelAndView mav = new ModelAndView();
		Book book = service.getById(bookId);
		mav.addObject("book", book);
		mav.setViewName("add");
		return mav;
	}
	
	
	
	
}
	
	
	
	
