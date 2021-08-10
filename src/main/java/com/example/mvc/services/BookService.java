package com.example.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.mvc.models.Book;
import com.example.mvc.repositories.BookRepository;

@Service
public class BookService {
	
	 private final BookRepository bookRepository;
	    
	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }

	    public List<Book> allBooks() {
	        return bookRepository.findAll();
	    }

	    public Book createBook(Book b) {
	        return bookRepository.save(b);
	    }

	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
	    	Book b= findBook(id);
	    	b.setTitle(title);
	    	b.setDescription(desc);
	    	b.setLanguage(lang);
	    	b.setNumberOfPages(numOfPages);
	        return bookRepository.save(b);
	    }
	    
	    public void deleteBook(Long id) {
	        bookRepository.deleteById(id);
	        
	    }

}
