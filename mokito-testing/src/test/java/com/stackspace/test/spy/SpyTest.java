package com.stackspace.test.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 * 1. Spy objects are very similar to the stubs, but they record information
 * about how they were executed.
 * 
 * 2. Its mostly used with stubbed external dependancy plus recording every
 * interaction with external dependency.
 * 
 * @author arjun
 *
 */
public class SpyTest {
	@Test
	public void demoSpyTest() {
		BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
		BookService bookService = new BookService(bookRepositorySpy);
		Book book1 = new Book(UUID.randomUUID().toString(), "Mockito In Action", 250, "654109175", "John Doe",
				LocalDate.now());
		Book book2 = new Book(UUID.randomUUID().toString(), "JUnit In Action", 290, "574514561", "John Doe",
				LocalDate.now());
		bookService.addBook(book1);
		bookService.addBook(book2);

		assertEquals(2, bookRepositorySpy.timesCalled());
		assertTrue(bookRepositorySpy.calledWith(book2));
	}
}
