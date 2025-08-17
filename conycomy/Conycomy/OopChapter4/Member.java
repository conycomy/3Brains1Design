package Conycomy.OopChapter4;
import Conycomy.OopChapter4.dto.BookRequest;
import Conycomy.OopChapter4.dto.BorrowResult;
import java.util.List;

public interface Member {
	List<BookRequest> requestToBorrowBooks();
	void notifyBorrowResult(BorrowResult result);
}