import dto.Book;
import object.BookCatalog;
import object.BookRentalHistory;
import object.DefaultLibrarian;
import object.InMemoryBookCatalog;
import object.InMemoryRentalHistory;
import object.Librarian;
import object.Member;

public class Controller {

    public static void main(String[] args) {
        BookCatalog catalog = new InMemoryBookCatalog();
        BookRentalHistory history = new InMemoryRentalHistory();
        Librarian librarian = new DefaultLibrarian(catalog, history);
        Member member1 = new Member(1L, "홍길동", librarian);
        Member member2 = new Member(2L, "이순신", librarian);

        // 1. 정상적으로 빌리는 경우
        System.out.println("\n[시나리오 1] 홍길동이 '토지' 1권 대여");
        member1.borrowBook("토지", 1);

        // 2. 재고가 부족한 경우
        System.out.println("\n[시나리오 2] 이순신이 '1984' 3권 대여 시도");
        member2.borrowBook("1984", 3);

        // 3. 존재하지 않는 책 대여 시도
        System.out.println("\n[시나리오 3] 홍길동이 '없는책' 대여 시도");
        member1.borrowBook("없는책", 1);

        // 4. 재고 소진 시 대여 불가 테스트
        System.out.println("\n[시나리오 4] 홍길동이 '데미안' 5권 대여");
        member1.borrowBook("데미안", 5);
        System.out.println("[시나리오 4-2] 이순신이 '데미안' 1권 대여 시도");
        member2.borrowBook("데미안", 1);

        System.out.println("\n=== 대여 이력 ===");
        for (Book book : history.getAllTitles()) {
            System.out.println(book.getTitle());
        }

        System.out.println("\n=== 대여 통계 ===");
        InMemoryRentalHistory inMemoryHistory = (InMemoryRentalHistory) history;
        for (var entry : inMemoryHistory.getStatisticsAsMap().entrySet()) {
            System.out.println(entry.getKey().getTitle() + " = " + entry.getValue());
        }
    }
}
