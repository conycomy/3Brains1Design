// BookRentalStat.java
package com.conycomy.dto;

public class BookRentalStat {

	private final String bookId;
	private final String title;
	private final int rentalCount;

	public BookRentalStat(String bookId, String title, int rentalCount) {
		this.bookId = bookId;
		this.title = title;
		this.rentalCount = rentalCount;
	}

	public String bookId() {
		return bookId;
	}

	public String title() {
		return title;
	}

	public int rentalCount() {
		return rentalCount;
	}
}