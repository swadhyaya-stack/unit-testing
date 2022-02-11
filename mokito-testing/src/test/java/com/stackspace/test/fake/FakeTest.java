package com.stackspace.test.fake;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 * 1. Fake objects are usally light weight objects used only for testing.They
 * have working implementation, but not an actual production object.
 * 
 * 2. Fake objects have functional implementation, but its in vbery basic form.
 * 
 * 3. For Example, instead of an actual production database we can use an
 * in-memory database, hashmap or list in test.
 */
public class FakeTest {

	@Test
	public void testBookService() {
		BookRepository repo = new FakeBookRepository();
		BookService service = new BookService(repo);
		service.addBook(new Book(UUID.randomUUID().toString(), "Mockito In Action", 250, "654109175", "John Doe",
				LocalDate.now()));
		service.addBook(new Book(UUID.randomUUID().toString(), "JUnit In Action", 290, "574514561", "John Doe",
				LocalDate.now()));

		assertEquals(2, service.numberOfAvailableBooks());
	}

	@Test
	public void testFakeWithMockito() {
		BookRepository bookRepository = mock(BookRepository.class);
		BookService bookService = new BookService(bookRepository);

		Book book1 = new Book(UUID.randomUUID().toString(), "Mockito In Action", 250, "654109175", "John Doe",
				LocalDate.now());
		Book book2 = new Book(UUID.randomUUID().toString(), "JUnit In Action", 290, "574514561", "John Doe",
				LocalDate.now());

		List<Book> bookList = Arrays.asList(book1, book2);

		when(bookRepository.findAll()).thenReturn(bookList);
		assertEquals(2, bookService.numberOfAvailableBooks());
	}

}
