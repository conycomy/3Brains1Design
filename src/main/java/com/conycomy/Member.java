// Member.java
package com.conycomy;
import com.conycomy.dto.BookRequest;
import com.conycomy.dto.BorrowResult;
import java.util.List;

public interface Member {
	List<BookRequest> requestToBorrowBooks();
	void notifyBorrowResult(BorrowResult result);
}