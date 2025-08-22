package Conycomy.OopChapter4;

import Conycomy.OopChapter4.dto.Book;
import java.util.List;

public interface BookRentalHistory {
	void recordRentals(List<Book> books);   // 성공한 대여만 기록
	int rentalCountOf(String bookId);       // 통계/조회
}