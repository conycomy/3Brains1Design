package model;

import dto.Book;
import dto.BookRequest;
import dto.RentalRecord;

public class DefaultLibrarian implements Librarian {

    private final BookCatalog bookCatalog;
    private final RentalHistory rentalHistory;

    public DefaultLibrarian(BookCatalog bookCatalog, RentalHistory rentalHistory) {
        this.bookCatalog = bookCatalog;
        this.rentalHistory = rentalHistory;
    }

    @Override
    public Book lendBook(BookRequest bookRequest) {
        // 책이 이용가능한지를 판별한다.
        if (bookCatalog.isAvailable(bookRequest)) {
            // 책이 이용가능하다면 카탈로그에서 빼서 대여함.
            Book rentedBook = bookCatalog.removeBook(bookRequest);

            // 책이 null 이라면 카탈로그에서 제거하는 것에서 실패한 것.
            if (rentedBook == null) {
                System.out.println("카탈로그에서 제거할 수 없습니다.");
                return null;
            }

            // 렌탈 데이터를 저장한다.
            RentalRecord rentalRecord = new RentalRecord(bookRequest.getMember(), rentedBook);
            rentalHistory.saveRentalRecord(rentalRecord);

            return rentedBook;
        }

        // 책이 이용가능하지 않다면 null 을 리턴
        System.out.println("책이 이용가능하지 않습니다.");
        return null;
    }
}
