package com.bookclub.dto;

public class Availability {

	public enum Status {
		AVAILABLE,
		NOT_FOUND,
		UNAVAILABLE
	}

	private final BookRequest request;
	private final Status status;
	private final Book matched;

	public Availability(BookRequest request, Status status, Book matched) {
		this.request = request;
		this.status = status;
		this.matched = matched;
	}

	public BookRequest request() {
		return request;
	}

	public Status status() {
		return status;
	}

	public Book matched() {
		return matched;
	}
}



}
