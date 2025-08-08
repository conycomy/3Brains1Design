package dto;


import object.Member;

public class RentalRecord {

    private Member member;
    private Book book;

    public RentalRecord(object.Member member, Book book) {
        this.member = member;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public object.Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
