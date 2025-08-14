package com.conycomy;

import com.conycomy.dto.*;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {


		// 1) BookCatalog: 요청은 무시하고 하드코딩된 10개 가용성 응답을 그대로 반환
		BookCatalog catalog = new BookCatalog() {
			@Override
			public List<Availability> checkAvailability(List<BookRequest> requests) {
				return Arrays.asList(
					new Availability(new BookRequest("해리포터와 마법사의 돌", "J.K. 롤링"),
						Availability.Status.AVAILABLE,
						new Book("B001", "해리포터와 마법사의 돌", "J.K. 롤링")),
					new Availability(new BookRequest("반지의 제왕: 반지 원정대", "J.R.R. 톨킨"),
						Availability.Status.AVAILABLE,
						new Book("B002", "반지의 제왕: 반지 원정대", "J.R.R. 톨킨")),
					new Availability(new BookRequest("어린 왕자", "생텍쥐페리"),
						Availability.Status.UNAVAILABLE,
						new Book("B003", "어린 왕자", "생텍쥐페리")),
					new Availability(new BookRequest("데미안", "헤르만 헤세"),
						Availability.Status.AVAILABLE,
						new Book("B004", "데미안", "헤르만 헤세")),
					new Availability(new BookRequest("1984", "조지 오웰"),
						Availability.Status.AVAILABLE,
						new Book("B005", "1984", "조지 오웰")),
					new Availability(new BookRequest("죄와 벌", "도스토옙스키"),
						Availability.Status.UNAVAILABLE,
						new Book("B006", "죄와 벌", "도스토옙스키")),
					new Availability(new BookRequest("위대한 개츠비", "F. 스콧 피츠제럴드"),
						Availability.Status.AVAILABLE,
						new Book("B007", "위대한 개츠비", "F. 스콧 피츠제럴드")),
					new Availability(new BookRequest("노인과 바다", "어니스트 헤밍웨이"),
						Availability.Status.AVAILABLE,
						new Book("B008", "노인과 바다", "어니스트 헤밍웨이")),
					new Availability(new BookRequest("나미야 잡화점의 기적", "히가시노 게이고"),
						Availability.Status.AVAILABLE,
						new Book("B009", "나미야 잡화점의 기적", "히가시노 게이고")),
					new Availability(new BookRequest("달과 6펜스", "서머싯 몸"),
						Availability.Status.AVAILABLE,
						new Book("B010", "달과 6펜스", "서머싯 몸"))
				);
			}
		};

		// 2) BookRentalHistory: 성공한 책들만 기록 출력
		BookRentalHistory history = new BookRentalHistory() {
			@Override
			public void recordRentals(List<Book> books) {
				System.out.println("📚 대여 기록(성공 건): " + books.size() + "권");
				for (Book b : books) {
					System.out.println("- " + b.title() + " (" + b.id() + ")");
				}
			}

			@Override
			public int rentalCountOf(String bookId) {
				if (bookId.equals("B001")) {
					return 5;
				}
				if (bookId.equals("B002")) {
					return 3;
				}
				if (bookId.equals("B003")) {
					return 0;
				}
				return 1;
			}
		};

		// 3) Member: 수작업으로 10권 요청(제목+저자)
		Member member = new Member() {
			@Override
			public List<BookRequest> requestToBorrowBooks() {
				return Arrays.asList(
					new BookRequest("해리포터와 마법사의 돌", "J.K. 롤링"),
					new BookRequest("반지의 제왕: 반지 원정대", "J.R.R. 톨킨"),
					new BookRequest("어린 왕자", "생텍쥐페리"),
					new BookRequest("데미안", "헤르만 헤세"),
					new BookRequest("1984", "조지 오웰"),
					new BookRequest("죄와 벌", "도스토옙스키"),
					new BookRequest("위대한 개츠비", "F. 스콧 피츠제럴드"),
					new BookRequest("노인과 바다", "어니스트 헤밍웨이"),
					new BookRequest("나미야 잡화점의 기적", "히가시노 게이고"),
					new BookRequest("달과 6펜스", "서머싯 몸")
				);
			}

			@Override
			public void notifyBorrowResult(BorrowResult result) {
				System.out.println("✅ 대여 결과 통지");
				System.out.println("성공: " + result.success().size() + "권");
				System.out.println("실패: " + result.failures().size() + "권");
			}
		};





		Librarian librarian = new DefaultLibrarian(catalog, history);
		librarian.lendBooksTo(member);
	}
}