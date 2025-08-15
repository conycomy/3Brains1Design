package com.conycomy.dto;

public class BookRequest {
	private final String title;
	private final String author;
	public BookRequest(String title, String author) {
		this.title = title; this.author = author;
	}
	public String title() { return title; }
	public String author() { return author; }
}

