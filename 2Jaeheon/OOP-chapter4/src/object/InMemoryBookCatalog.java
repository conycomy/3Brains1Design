package object;

import dto.Book;
import java.util.HashMap;
import java.util.Map;

public class InMemoryBookCatalog implements BookCatalog {

    // 책과 재고가 들어있음
    private Map<Book, Integer> inventory = new HashMap<>();

    public InMemoryBookCatalog() {
        inventory.put(new Book(1L, "토지", "박경리", "마로니에북스"), 3);
        inventory.put(new Book(2L, "데미안", "헤르만 헤세", "민음사"), 5);
        inventory.put(new Book(3L, "1984", "조지 오웰", "민음사"), 2);
    }

    @Override
    public Map<Book, Integer> searchAvailableBook(String title) {
        // 책이 이용가능한지 조사해서 반환해줘야함.

        for (Map.Entry<Book, Integer> entry : inventory.entrySet()) {
            Book searchedBook = entry.getKey();
            Integer requiredBookCount = entry.getValue();

            if (searchedBook.getTitle().equals(title) && requiredBookCount > 0) {
                Map<Book, Integer> result = new HashMap<>();
                result.put(searchedBook, requiredBookCount);
                return result;
            }
        }
        return Map.of();
    }

    @Override
    public void decreaseStock(Book book, int quantity) {
        if (!inventory.isEmpty()) {
            int currentStock = inventory.get(book);
            if (currentStock >= quantity) {
                inventory.put(book, currentStock - quantity);
            }
        }
    }
}
