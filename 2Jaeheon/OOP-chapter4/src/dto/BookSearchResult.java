package dto;

public class BookSearchResult {

    private final Book book;
    private final int stock;

    public BookSearchResult(Book book, int stock) {
        this.book = book;
        this.stock = stock;
    }

    public Book getBook() {
        return book;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "BookSearchResult{" +
            "book=" + book +
            ", stock=" + stock +
            '}';
    }
}
