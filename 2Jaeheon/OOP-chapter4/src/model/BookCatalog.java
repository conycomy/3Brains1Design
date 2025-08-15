package model;

import dto.Book;
import dto.BookRequest;

public interface BookCatalog {

    boolean isAvailable(BookRequest bookRequest);
    Book removeBook(BookRequest bookRequest);
}
