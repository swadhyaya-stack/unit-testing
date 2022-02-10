package com.stackspace.test.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryMock implements BookRepository {
	int saveCalled = 0;
	Book lastsavedBook = null;

	@Override
	public void save(Book book) {
		saveCalled++;
		lastsavedBook = book;
	}

	public void verify(Book book, int times) {
		assertEquals(times, saveCalled);
		assertEquals(book, lastsavedBook);
	}
}
