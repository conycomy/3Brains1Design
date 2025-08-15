package dto;

import java.util.Date;

public class Book {

    String bookTitle;
    String author;
    Date publishedDate;
    int price;

    public Book(String bookTitle, String author, Date publishedDate, int price) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publishedDate = publishedDate;
        this.price = price;
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

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
            "bookTitle='" + bookTitle + '\'' +
            ", author='" + author + '\'' +
            ", publishedDate=" + publishedDate +
            ", price=" + price +
            '}';
    }
}
