package com.stackspace.test.spy;

import java.util.Collection;

public interface BookRepository {
	void save(Book book);

	Collection<Book> findAll();
}
