package com.koti.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koti.entity.Book;
import java.util.List;


public interface BookRepo extends JpaRepository<Book, Integer> {
	
	public  List<Book> findByActiveSW(String status);

}
