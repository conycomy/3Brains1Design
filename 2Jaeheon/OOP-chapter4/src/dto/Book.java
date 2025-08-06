package dto;

public class Book {

    private Long bookNumber;
    private String title;
    private String author;
    private String publisher;

    public Book(Long bookNumber, String title, String author, String publisher) {
        this.bookNumber = bookNumber;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public Long getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Long bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    @Override
    public String toString() {
        return "Book{" +
            "bookNumber=" + bookNumber +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", publisher='" + publisher + '\'' +
            '}';
    }
}
