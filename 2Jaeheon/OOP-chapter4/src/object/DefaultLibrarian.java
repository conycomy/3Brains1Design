package object;

import dto.Book;
import dto.RentalRecord;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DefaultLibrarian implements Librarian {

    private final BookCatalog bookCatalog;
    private final BookRentalHistory bookRentalHistory;

    public DefaultLibrarian(BookCatalog bookCatalog, BookRentalHistory bookRentalHistory) {
        this.bookCatalog = bookCatalog;
        this.bookRentalHistory = bookRentalHistory;
    }

    @Override
    public Map<Book, Integer> findBook(String title, int bookCount) {
        Map<Book, Integer> searchedBook = bookCatalog.searchAvailableBook(title);

        if (searchedBook.isEmpty()) {
            return Map.of();
        }

        Entry<Book, Integer> bookEntry = searchedBook.entrySet().iterator().next();
        if (bookEntry.getValue() < bookCount) {
            return Map.of(); // 재고 부족
        }

        return searchedBook;
    }

    @Override
    public void saveRentalRecord(Member member, Book book) {
        bookCatalog.decreaseStock(book); // 재고를 줄이고 저장
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
