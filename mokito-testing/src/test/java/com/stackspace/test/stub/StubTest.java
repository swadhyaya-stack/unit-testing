package com.stackspace.test.stub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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

	@Test
	public void testStubWithMockito() {
		BookRepository bookRepository = mock(BookRepository.class);
		BookService bookService = new BookService(bookRepository);
		Book book1 = new Book(UUID.randomUUID().toString(), "Mockito In Action", 500, "654109175", "John Doe",
				LocalDate.now());
		Book book2 = new Book(UUID.randomUUID().toString(), "JUnit In Action", 400, "574514561", "John Doe",
				LocalDate.now());
		List<Book> bookList = Arrays.asList(book1, book2);
		when(bookRepository.findNewBoks(7)).thenReturn(bookList);

		List<Book> booksWithDisscount = bookService.getNewBookWithAppliedDiscount(10, 7);

		assertEquals(2, booksWithDisscount.size());
		assertEquals(450, booksWithDisscount.get(0).getPrice());
		assertEquals(360, booksWithDisscount.get(1).getPrice());
	}
}
