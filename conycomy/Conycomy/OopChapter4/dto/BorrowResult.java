package Conycomy.OopChapter4.dto;
import java.util.List;

public class BorrowResult {
	private final List<Book> success;                 // 실제로 빌려진 책들
	private final List<Availability> failures;        // 실패(없음/대여중) 내역

	public BorrowResult(List<Book> success, List<Availability> failures) {
		this.success = success; this.failures = failures;
	}
	public List<Book> success() { return success; }
	public List<Availability> failures() { return failures; }
	public boolean allSucceeded() { return failures.isEmpty(); }
}