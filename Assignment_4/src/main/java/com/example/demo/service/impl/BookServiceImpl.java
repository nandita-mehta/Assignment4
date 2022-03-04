package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
    public BookServiceImpl(BookDao bookDao) {
    	super();
    	this.bookDao = bookDao;
    }

    @Override
    public void deleteBookById(long id) {
    	bookDao.findBookById(id);
    	bookDao.deleteBookById(id);
    }
    
    @Override
    public List<Book> findAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book findBookById(long id) {
        return bookDao.findBookById(id);
    }
    
    @Override
    public Book saveBook(Book book) {
    	return bookDao.saveBook(book);
    }
}