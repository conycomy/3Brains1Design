package com.conycomy;

import com.conycomy.dto.Availability;
import com.conycomy.dto.Book;
import com.conycomy.dto.BookRequest;
import com.conycomy.dto.BorrowResult;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultLibrarian implements Librarian {

	private final BookCatalog bookCatalog;
	private final BookRentalHistory bookRentalHistory;

	public DefaultLibrarian(BookCatalog bookCatalog, BookRentalHistory bookRentalHistory) {
		this.bookCatalog = bookCatalog;
		this.bookRentalHistory = bookRentalHistory;
	}


	@Override
	public BorrowResult lendBooksTo(Member member) {
		List<BookRequest> requests = member.requestToBorrowBooks();

		List<Availability> checks = bookCatalog.checkAvailability(requests); // 요청별 가용성 응답
		List<Book> toBorrow = checks.stream()
			.filter(a -> a.status() == Availability.Status.AVAILABLE)
			.map(Availability::matched)
			.collect(Collectors.toList());

		bookRentalHistory.recordRentals(toBorrow);

		List<Availability> failures = checks.stream()
			.filter(a -> a.status() != Availability.Status.AVAILABLE)
			.collect(Collectors.toList());

		BorrowResult result = new BorrowResult(toBorrow, failures);
		member.notifyBorrowResult(result);
		return result;
	}
}

