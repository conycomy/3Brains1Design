package Conycomy.OopChapter4;
import Conycomy.OopChapter4.dto.Book;
import Conycomy.OopChapter4.dto.BookRentalStat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryBookRentalHistory implements BookRentalHistory {

	private final Map<String, Integer> rentalStats = new HashMap<>();

	@Override
	public void recordRentals(List<Book> books) {
		for (Book book : books) {
			String bookId = book.id();
			int count = rentalStats.getOrDefault(bookId, 0);
			rentalStats.put(bookId, count + 1);
		}
	}

	@Override
	public int rentalCountOf(String bookId) {
		return rentalStats.getOrDefault(bookId, 0);
	}

	// DTO 변환 메서드 추가!
	public List<BookRentalStat> toStatList(Map<String, Book> bookInfoMap) {
		List<BookRentalStat> result = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : rentalStats.entrySet()) {
			String bookId = entry.getKey();
			int count = entry.getValue();
			Book book = bookInfoMap.get(bookId);

			if (book != null) {
				result.add(new BookRentalStat(bookId, book.title(), count));
			}
		}

		return result;
	}
}