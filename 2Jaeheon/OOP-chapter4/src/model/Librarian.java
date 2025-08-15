package model;

import dto.Book;
import dto.BookRequest;

public interface Librarian {

    Book lendBook(BookRequest bookRequest);
}
