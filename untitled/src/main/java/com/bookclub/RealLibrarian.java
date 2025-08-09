package com.bookclub;

import com.bookclub.dto.BorrowResult;

public class RealLibrarian implements Libranian {

	private final BookCatalog bookCatalog;
	private final BookRentalHistory bookRentalHistory;

	public RealLibrarian(BookCatalog bookCatalog,
		BookRentalHistory bookRentalHistory) {
		this.bookCatalog = bookCatalog;
		this.bookRentalHistory = bookRentalHistory;
	}

	@Override
	public BorrowResult lendBooksTo(Member member) {
		return null;
	}
}
