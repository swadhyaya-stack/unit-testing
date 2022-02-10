package com.stackspace.test.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookRepositoryStub implements BookRepository {

	@Override
	public List<Book> findNewBoks(int days) {
		Book book1 = new Book(UUID.randomUUID().toString(), "Mockito In Action", 250, "654109175", "John Doe",
				LocalDate.now());
		Book book2 = new Book(UUID.randomUUID().toString(), "JUnit In Action", 290, "574514561", "John Doe",
				LocalDate.now());
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(book1);
		bookList.add(book2);
		return bookList;
	}

}
