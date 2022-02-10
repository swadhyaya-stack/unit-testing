package com.stackspace.test.dummy;

import java.util.logging.Logger;

public class BookService {
	private static Logger logger = Logger.getLogger(BookService.class.getName());
	private BookRepository bookRepository;
	private CourierService courierService;

	public BookService(BookRepository bookRepository, CourierService courierService) {
		super();
		this.bookRepository = bookRepository;
		this.courierService = courierService;
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
