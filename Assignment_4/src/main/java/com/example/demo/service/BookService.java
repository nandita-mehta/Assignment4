package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Book;

public interface BookService {
	
    public void deleteBookById(long id);
    
    public List<Book> findAllBooks();

    public Book findBookById(long id);
    
    public Book saveBook(Book book);
}