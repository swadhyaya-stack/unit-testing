package com.stackspace.test.stub;

import java.util.List;

public class BookService {
	private BookRepository bookRepository;

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public List<Book> getNewBookWithAppliedDiscount(int discountRate, int days) {
		List<Book> newBooks = bookRepository.findNewBoks(days);
		for (Book book : newBooks) {
			int price = book.getPrice();
			int newPrice = price - (discountRate * price / 100);
			book.setPrice(newPrice);
		}
		return newBooks;
	}
}
