package object;

import dto.Book;
import dto.BookSearchResult;
import dto.RentalRecord;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class DefaultLibrarian implements Librarian {

    private final BookCatalog bookCatalog;
    private final BookRentalHistory bookRentalHistory;

    public DefaultLibrarian(BookCatalog bookCatalog, BookRentalHistory bookRentalHistory) {
        this.bookCatalog = bookCatalog;
        this.bookRentalHistory = bookRentalHistory;
    }

    @Override
    public Optional<BookSearchResult> findBook(String title, int bookCount) {
        // 하나의 stream으로 최적화
        return bookCatalog.searchAvailableBook(title).entrySet().stream()
            .filter(entry -> entry.getValue() >= bookCount)
            .findFirst()
            .map(entry -> new BookSearchResult(entry.getKey(), entry.getValue()));
    }

    @Override
    public void saveRentalRecord(Member member, Book book, int quantity) {
        bookCatalog.decreaseStock(book, quantity); // 재고를 줄이고 저장
        bookRentalHistory.save(member, book);
    }

    @Override
    public List<Book> getAllRentalTitles() {
        return bookRentalHistory.getAllTitles();
    }

    @Override
    public List<RentalRecord> getAllRentalStatistics() {
        return bookRentalHistory.getRentalStatistics();
    }
}
