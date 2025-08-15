package model;

import dto.Book;
import dto.BookRequest;
import java.util.List;

public class InMemoryBookCatalog implements BookCatalog {

    private final List<Book> catalog;

    public InMemoryBookCatalog(List<Book> catalog) {
        this.catalog = catalog;
    }

    @Override
    public boolean isAvailable(BookRequest bookRequest) {

        // 카탈로그에서 선택한 책과, 사서가 요청한 책의 이름이 같고,
        // 저자가 같은 경우에는 책을 이용가능하도록 함.
        for (Book selectedBook : catalog) {
            if (matchesRequest(bookRequest, selectedBook)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Book removeBook(BookRequest bookRequest) {
        for (Book selectedBook : catalog) {
            if (matchesRequest(bookRequest, selectedBook)) {
                catalog.remove(selectedBook);
                return selectedBook;
            }
        }
        return null;
    }

    private static boolean matchesRequest(BookRequest bookRequest, Book selectedBook) {
        return selectedBook.getBookTitle().equals(bookRequest.getBookTitle())
            && selectedBook.getAuthor().equals(bookRequest.getAuthor());
    }
}
