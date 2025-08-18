package Conycomy.OopChapter4;

import Conycomy.OopChapter4.dto.Availability;
import Conycomy.OopChapter4.dto.Book;
import Conycomy.OopChapter4.dto.BookRequest;

import java.util.*;

public class MemoryBookCatalog implements BookCatalog {

	private final Map<String, List<Book>> catalog; // title 기준으로 도서 분류

	public MemoryBookCatalog(List<Book> books) {
		this.catalog = new HashMap<>();
		for (Book book : books) {
			String key = book.title().toLowerCase(); // title을 소문자로 통일하여 key 사용
			catalog.computeIfAbsent(key, k -> new ArrayList<>()).add(book);
		}
	}

	@Override
	public List<Availability> checkAvailability(List<BookRequest> requests) {
		List<Availability> result = new ArrayList<>();

		for (BookRequest bookRequest : requests) {
			String key = bookRequest.title().toLowerCase();
			List<Book> candidateBooks = catalog.getOrDefault(key, Collections.emptyList());

			Optional<Book> matchedBook = candidateBooks.stream()
				.filter(book -> book.author().equalsIgnoreCase(bookRequest.author()))
				.findFirst();

			if (matchedBook.isPresent()) {
				result.add(new Availability(
					bookRequest,
					Availability.Status.AVAILABLE,
					matchedBook.get()
				));
			} else {
				result.add(new Availability(
					bookRequest,
					Availability.Status.UNAVAILABLE,
					null
				));
			}
		}

		return result;
	}
}