package com.stackspace.test.fake;

import java.util.Collection;

public interface BookRepository {
	void save(Book book);

	Collection<Book> findAll();
}
