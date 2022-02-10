package com.stackspace.test.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {
	private static Map<String, Book> bookDB = new HashMap<String, Book>();

	@Override
	public void save(Book book) {
		bookDB.put(book.getId(), book);
	}

	@Override
	public Collection<Book> findAll() {
		return bookDB.values();
	}

}
