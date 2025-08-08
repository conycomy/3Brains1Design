package object;

import dto.Book;
import java.util.Map;
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

    public void borrowBook(String bookTitle, int bookCount) {
        Map<Book, Integer> availableBook = librarian.findBook(bookTitle, bookCount);

        if (availableBook.isEmpty()) {
            System.out.println("책을 찾을 수 없습니다.");
            return;
        }

        Book selectedBook = availableBook.keySet().iterator().next();
        int availableCount = availableBook.get(selectedBook);

        if (availableCount < bookCount) {
            System.out.println("요청한 수량이 존재하지 않습니다.");
            return;
        }

        librarian.saveRentalRecord(this, selectedBook);
        System.out.println("대여 성공하였습니다.");
    }
}
