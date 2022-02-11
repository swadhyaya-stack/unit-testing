package com.stackspace.test.mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 * 1. Mock works very similar to the Spy.
 * 
 * 2. Mock object record method calls on it, and verifies later that the
 * recorded calls match.
 * 
 * 3. The assert and behavior verification is done at mock object.
 * 
 * @author arjun
 *
 */
public class MockTest {
	@Test
	public void demoMockTest() {
		BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
		BookService bookService = new BookService(bookRepositoryMock);
		Book book1 = new Book(UUID.randomUUID().toString(), "Mockito In Action", 250, "654109175", "John Doe",
				LocalDate.now());
		Book book2 = new Book(UUID.randomUUID().toString(), "JUnit In Action", 290, "574514561", "John Doe",
				LocalDate.now());
		bookService.addBook(book1);// call save and add
		bookService.addBook(book2);// return

		bookRepositoryMock.verify(book1, 1);
	}

	@Test
	public void testMockWithMockito() {
		BookRepository bookRepository = mock(BookRepository.class);
		BookService bookService = new BookService(bookRepository);
		Book book1 = new Book(UUID.randomUUID().toString(), "Mockito In Action", 250, "654109175", "John Doe",
				LocalDate.now());
		Book book2 = new Book(UUID.randomUUID().toString(), "JUnit In Action", 290, "574514561", "John Doe",
				LocalDate.now());
		bookService.addBook(book1);// call save and add
		bookService.addBook(book2);// return

		verify(bookRepository, times(1)).save(book1);
		verify(bookRepository, times(0)).save(book2);
	}
}
