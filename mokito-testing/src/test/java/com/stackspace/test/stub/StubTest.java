package com.stackspace.test.stub;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 1. Stub Object provides predefined answers to method execution made during
 * the test. 2. The behavior is hardcoded programmatically for a particular
 * test. 3. Instead of calling external service, stub called and it return back
 * an expected response.
 * 
 * @author arjun
 *
 */
public class StubTest {
	@Test
	public void testStub() {
		BookRepository bookRepository = new BookRepositoryStub();
		BookService bookService = new BookService(bookRepository);

		List<Book> newBooks = bookService.getNewBookWithAppliedDiscount(10, 7);

		assertEquals(2, newBooks.size());
		assertEquals(225, newBooks.get(0).getPrice());
		assertEquals(261, newBooks.get(1).getPrice());
	}
}
