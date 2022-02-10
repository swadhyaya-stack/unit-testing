package com.stackspace.test.spy;

import java.util.logging.Logger;

public class BookService {
	private static Logger logger = Logger.getLogger(BookService.class.getName());
	private BookRepository bookRepository;

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public void addBook(Book book) {
		logger.info("Adding book to the database");
		bookRepository.save(book);
	}

	public int numberOfAvailableBooks() {
		logger.info("Fetching the number of books available in the database");
		return bookRepository.findAll().size();
	}
}
