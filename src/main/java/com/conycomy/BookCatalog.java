package com.conycomy;
import com.conycomy.dto.Availability;
import com.conycomy.dto.BookRequest;
import java.util.List;

public interface BookCatalog {
	List<Availability> checkAvailability(List<BookRequest> requests);
}