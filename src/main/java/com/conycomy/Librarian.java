package com.conycomy;

import com.conycomy.dto.BorrowResult;

public interface Librarian {

	BorrowResult lendBooksTo(Member member);
}