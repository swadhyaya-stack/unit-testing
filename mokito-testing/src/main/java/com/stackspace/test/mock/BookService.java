package com.stackspace.test.mock;

public class BookService {
	private BookRepository bookRepository;

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public void addBook(Book book) {
		if (book.getPrice() > 250) {
			return;
		}
		bookRepository.save(book);
	}
}
