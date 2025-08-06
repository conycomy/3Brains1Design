package object;

import dto.Book;
import dto.BookSearchResult;
import dto.RentalRecord;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Librarian {

    public Optional<BookSearchResult> findBook(String title, int requiredStock);

    public void saveRentalRecord(Member member, Book book);

    public List<Book> getAllRentalTitles();

    public List<RentalRecord> getAllRentalStatistics();
}
