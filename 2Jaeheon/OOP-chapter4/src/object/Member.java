package object;

import dto.Book;
import dto.BookSearchResult;
import java.util.Optional;

public class Member {

    private Long id;
    private String name;
    private Librarian librarian;

    public Member(Long id, String name, Librarian librarian) {
        this.id = id;
        this.name = name;
        this.librarian = librarian;
    }

    public void borrowBook(String bookTitle, int requiredStock) {
        Optional<BookSearchResult> bookSearchResult = librarian.findBook(bookTitle, requiredStock);

        if (bookSearchResult.isEmpty()) {
            System.out.println("책을 찾을 수 없습니다.");
            return;
        }

        BookSearchResult result = bookSearchResult.get();
        Book book = result.getBook();
        int availableStock = result.getStock();

        if (availableStock < requiredStock) {
            System.out.println("요청한 수량이 존재하지 않습니다.");
            return;
        }

        librarian.saveRentalRecord(this, book, requiredStock);
        System.out.println("대여 성공하였습니다.");
    }
}
