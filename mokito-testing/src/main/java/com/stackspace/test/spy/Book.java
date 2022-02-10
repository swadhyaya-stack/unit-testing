package com.stackspace.test.spy;

import java.time.LocalDate;

public class Book {
	private String id;
	private String title;
	private int price;
	private String isbnNumber;
	private String author;
	private LocalDate publishedDate;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String id, String title, int price, String isbnNumber, String author, LocalDate publishedDate) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.isbnNumber = isbnNumber;
		this.author = author;
		this.publishedDate = publishedDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

}
