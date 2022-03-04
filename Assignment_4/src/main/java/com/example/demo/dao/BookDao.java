package com.example.demo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

@Component
public class BookDao {
	private EntityManager entityManager;
	
	@Autowired
    public BookDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
	public void deleteBookById(long id) {
        Query query = (Query) entityManager.createQuery("delete from books where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
	public Book findBookById(long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }
	public List<Book> getAllBooks() {
        Query query= (Query) entityManager.createQuery("from books", Book.class);
		List<Book> book = query.getResultList();
		System.out.print("Booksss");
        return book;
    }
    public Book saveBook(Book book) {
    	Book dbBook = entityManager.merge(book);
    	book.setId(dbBook.getId());
        return book;
    }
}