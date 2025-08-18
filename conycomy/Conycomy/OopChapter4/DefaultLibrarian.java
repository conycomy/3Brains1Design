package Conycomy.OopChapter4;

import Conycomy.OopChapter4.dto.Availability;
import Conycomy.OopChapter4.dto.Book;
import Conycomy.OopChapter4.dto.BookRequest;
import Conycomy.OopChapter4.dto.BorrowResult;
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

		// 전체 가용성 체크
		List<Availability> checks = bookCatalog.checkAvailability(requests);

		//  대여 가능한 책 (AVAILABLE만)
		List<Book> toBorrow = checks.stream()
			.filter(a -> a.status() == Availability.Status.AVAILABLE)
			.map(Availability::matched)
			.collect(Collectors.toList());

		//  대여 실패 (UNAVAILABLE 또는 NOT_FOUND)
		List<Availability> failures = checks.stream()
			.filter(a -> a.status() != Availability.Status.AVAILABLE)
			.collect(Collectors.toList());

		// 대여 기록 저장
		bookRentalHistory.recordRentals(toBorrow);

		// 결과 반환 및 알림
		BorrowResult result = new BorrowResult(toBorrow, failures);
		member.notifyBorrowResult(result);
		return result;
	}
}

