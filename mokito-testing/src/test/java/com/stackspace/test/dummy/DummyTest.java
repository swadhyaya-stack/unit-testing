package com.stackspace.test.dummy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 * 1. It doesn't have any business logic.
 * 
 * 2. It is an object that is used only for code to compile.
 * 
 * 3.For example, an object passed as a parameter to a constructor. It is passed
 * just to make code compile.
 * 
 * @author arjun
 *
 */
public class DummyTest {
	@Test
	public void testDummy() {
		BookRepository bookRepository = new FakeBookRepository();
		CourierService courierService = new DummyCourierService();
		BookService bookService = new BookService(bookRepository, courierService);

		bookService.addBook(new Book(UUID.randomUUID().toString(), "Mockito In Action", 250, "654109175", "John Doe",
				LocalDate.now()));
		bookService.addBook(new Book(UUID.randomUUID().toString(), "JUnit In Action", 290, "574514561", "John Doe",
				LocalDate.now()));

		assertEquals(2, bookService.numberOfAvailableBooks());
	}

	@Test
	public void demoDummyWithMockito() {
		BookRepository bookRepository = mock(BookRepository.class);
		CourierService courierService = mock(CourierService.class);
		BookService bookService = new BookService(bookRepository, courierService);

		Book book1 = new Book(UUID.randomUUID().toString(), "Mockito In Action", 250, "654109175", "John Doe",
				LocalDate.now());
		Book book2 = new Book(UUID.randomUUID().toString(), "JUnit In Action", 290, "574514561", "John Doe",
				LocalDate.now());
		List<Book> bookList = Arrays.asList(book1, book2);
		when(bookRepository.findAll()).thenReturn(bookList);
		assertEquals(2, bookService.numberOfAvailableBooks());
	}
}
