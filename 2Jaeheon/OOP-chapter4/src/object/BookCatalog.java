package object;

import dto.Book;
import java.util.Map;

public interface BookCatalog {

    public Map<Book, Integer> searchAvailableBook(String title);

    void decreaseStock(Book book); // 재고 감소
}
