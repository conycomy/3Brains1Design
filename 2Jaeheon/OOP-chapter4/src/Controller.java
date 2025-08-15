import dto.Book;
import dto.BookRequest;
import dto.RentalRecord;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.BookCatalog;
import model.DefaultLibrarian;
import model.InMemoryBookCatalog;
import model.InMemoryRentalHistory;
import model.Librarian;
import model.Member;
import model.RentalHistory;

public class Controller {

    public static void main(String[] args) {
        // 도서관에 도서를 비치하고 대여 기록을 초기화합니다.
        List<Book> initialBooks = new ArrayList<>();
        initialBooks.add(new Book("반지의 제왕", "J.R.R. 톨킨", new Date(), 50));
        initialBooks.add(new Book("호빗", "J.R.R. 톨킨", new Date(), 40));
        initialBooks.add(new Book("1984", "조지 오웰", new Date(), 30));
        initialBooks.add(new Book("동물농장", "조지 오웰", new Date(), 25));
        initialBooks.add(new Book("위대한 개츠비", "F. 스콧 피츠제럴드", new Date(), 35));

        BookCatalog bookCatalog = new InMemoryBookCatalog(initialBooks);
        Map<Member, Book> rentalMap = new HashMap<>();
        RentalHistory rentalHistory = new InMemoryRentalHistory(rentalMap);

        // 사서를 생성합니다.
        Librarian librarian = new DefaultLibrarian(bookCatalog, rentalHistory);

        // 회원을 생성합니다.
        Member member1 = new Member("1", "김철수", "chulsoo.kim@example.com");
        Member member2 = new Member("2", "이영희", "younghee.lee@example.com");
        Member member3 = new Member("3", "박민수", "minsu.park@example.com");

        System.out.println("--- 도서관 시스템 테스트 시작 ---");

        // 김철수님이 '호빗' 책 대여를 요청합니다. (성공 케이스)
        System.out.println("\n--- 테스트 1: 정상적인 책 대여 ---");
        System.out.println(member1.getName() + "님이 '호빗' 책 대여를 요청합니다.");
        BookRequest request1 = new BookRequest("호빗", "J.R.R. 톨킨", member1);
        Book rentedBook1 = librarian.lendBook(request1);

        if (rentedBook1 != null) {
            System.out.println("대여 성공: " + rentedBook1.getBookTitle());
        } else {
            System.out.println("'호빗' 대여에 실패했습니다.");
        }
        System.out.println("현재 총 대여 기록 수: " + rentalHistory.getAllRentalRecords().size());
        printAllRentalRecords(rentalHistory);

        // 이영희님이 이미 대여된 '호빗' 책 대여를 요청합니다. (실패 케이스)
        System.out.println("\n--- 테스트 2: 이미 대여된 책 대여 시도 ---");
        System.out.println(member2.getName() + "님이 '호빗' 책 대여를 요청합니다.");
        BookRequest request2 = new BookRequest("호빗", "J.R.R. 톨킨", member2);
        Book rentedBook2 = librarian.lendBook(request2);

        if (rentedBook2 != null) {
            System.out.println("대여 성공: " + rentedBook2.getBookTitle());
        } else {
            System.out.println("'호빗'은 현재 대여가 불가능합니다.");
        }
        System.out.println("현재 총 대여 기록 수: " + rentalHistory.getAllRentalRecords().size());
        printAllRentalRecords(rentalHistory);

        // 박민수님이 '반지의 제왕' 책 대여를 요청합니다. (성공 케이스)
        System.out.println("\n--- 테스트 3: 다른 책 정상 대여 ---");
        System.out.println(member3.getName() + "님이 '반지의 제왕' 책 대여를 요청합니다.");
        BookRequest request3 = new BookRequest("반지의 제왕", "J.R.R. 톨킨", member3);
        Book rentedBook3 = librarian.lendBook(request3);

        if (rentedBook3 != null) {
            System.out.println("대여 성공: " + rentedBook3.getBookTitle());
        } else {
            System.out.println("'반지의 제왕' 대여에 실패했습니다.");
        }
        System.out.println("현재 총 대여 기록 수: " + rentalHistory.getAllRentalRecords().size());
        printAllRentalRecords(rentalHistory);

        // 김철수님이 존재하지 않는 '어린왕자' 책 대여를 요청합니다. (실패 케이스)
        System.out.println("\n--- 테스트 4: 존재하지 않는 책 대여 시도 ---");
        System.out.println(member1.getName() + "님이 '어린왕자' 책 대여를 요청합니다.");
        BookRequest request4 = new BookRequest("어린왕자", "생텍쥐페리", member1);
        Book rentedBook4 = librarian.lendBook(request4);

        if (rentedBook4 != null) {
            System.out.println("대여 성공: " + rentedBook4.getBookTitle());
        } else {
            System.out.println("'어린왕자'는 없는 책이라 대여할 수 없습니다.");
        }
        System.out.println("현재 총 대여 기록 수: " + rentalHistory.getAllRentalRecords().size());
        printAllRentalRecords(rentalHistory);

        // 이영희님이 '1984' 책 대여를 요청합니다. (성공 케이스)
        System.out.println("\n--- 테스트 5: 또 다른 책 정상 대여 ---");
        System.out.println(member2.getName() + "님이 '1984' 책 대여를 요청합니다.");
        BookRequest request5 = new BookRequest("1984", "조지 오웰", member2);
        Book rentedBook5 = librarian.lendBook(request5);

        if (rentedBook5 != null) {
            System.out.println("대여 성공: " + rentedBook5.getBookTitle());
        } else {
            System.out.println("'1984' 대여에 실패했습니다.");
        }
        System.out.println("현재 총 대여 기록 수: " + rentalHistory.getAllRentalRecords().size());
        printAllRentalRecords(rentalHistory);

        System.out.println("\n--- 도서관 시스템 테스트 종료 ---");
    }

    // 모든 대여 기록을 출력하는 헬퍼 메서드
    private static void printAllRentalRecords(RentalHistory rentalHistory) {
        System.out.println("--- 현재 대여 기록 목록 ---");
        List<RentalRecord> records = rentalHistory.getAllRentalRecords();
        if (records.isEmpty()) {
            System.out.println("대여 기록이 없습니다.");
        } else {
            for (RentalRecord record : records) {
                System.out.println(
                    "- 회원: " + record.getMember().getName() + ", 책: " + record.getBook()
                        .getBookTitle());
            }
        }
        System.out.println("-----------------------");
    }
}