package com.stackspace.test.stub;

import java.util.List;

public interface BookRepository {
	List<Book> findNewBoks(int days);
}
