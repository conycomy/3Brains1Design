package dto;

import model.Member;

public class RentalRecord {

    private Member member;
    private Book book;

    public RentalRecord(model.Member member, Book book) {
        this.member = member;
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

}
