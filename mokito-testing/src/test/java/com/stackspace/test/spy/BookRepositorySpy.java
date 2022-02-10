package com.stackspace.test.spy;

import java.util.Collection;

public class BookRepositorySpy implements BookRepository {
	int saveCalled = 0;
	Book lastsavedBook = null;

	@Override
	public void save(Book book) {
		saveCalled++;
		lastsavedBook = book;
	}

	@Override
	public Collection<Book> findAll() {
		return null;
	}

	public int timesCalled() {
		return saveCalled;
	}

	public boolean calledWith(Book book) {
		return lastsavedBook.equals(book);
	}
}
