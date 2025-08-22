package Conycomy.OopChapter4;

import Conycomy.OopChapter4.dto.BorrowResult;

public interface Librarian {

	BorrowResult lendBooksTo(Member member);
}