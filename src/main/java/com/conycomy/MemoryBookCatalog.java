package com.conycomy;

import com.conycomy.dto.Availability;
import com.conycomy.dto.Book;
import com.conycomy.dto.BookRequest;
import java.util.ArrayList;
import java.util.List;

public class MemoryBookCatalog implements BookCatalog {

	private final List<Book> books;

	public MemoryBookCatalog(List<Book> books) {
		this.books = books;
	}

	@Override
	public List<Availability> checkAvailability(List<BookRequest> requests) {
		List<Availability> result = new ArrayList<>();

		for (BookRequest bookRequest : requests) {
			boolean isAvailable = false;

			for (Book book : books) {
				if (book.title().equalsIgnoreCase(book.title())
					&& book.author().equalsIgnoreCase(book.author())) {

					Availability availability = new Availability(
						bookRequest,
						Availability.Status.AVAILABLE,
						book
					);
					result.add(availability);
					isAvailable = true;
					break;
				}
			}

			if (!isAvailable) {
				Availability availability = new Availability(
					bookRequest,
					Availability.Status.AVAILABLE,
					null

				);
				result.add(availability);

			}
		}
		return result;
	}
}