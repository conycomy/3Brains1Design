package Conycomy.OopChapter4;

import Conycomy.OopChapter4.dto.Availability;
import Conycomy.OopChapter4.dto.BookRequest;
import java.util.List;

public interface BookCatalog {

	List<Availability> checkAvailability(List<BookRequest> requests);
}