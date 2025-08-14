package dto;

import model.Member;

public class BookRequest {

    private String bookTitle;
    private String author;
    private model.Member member;

    public BookRequest(String bookTitle, String author, model.Member member) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.member = member;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
