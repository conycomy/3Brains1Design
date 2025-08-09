package com.bookclub.dto;

import java.util.List;

public class BorrowResult {

	private final List<Book> success;
	private final List<Availability> failures;

	public BorrowResult(List<Book> success, List<Availability> failures) {
		this.success = success;
		this.failures = failures;
	}

	public List<Book> success() {
		return success;
	}

	public List<Availability> failures() {
		return failures;
	}
}