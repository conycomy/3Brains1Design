package Conycomy.OopChapter4.dto;

public class Book {
	private final String id;
	private final String title;
	private final String author;
	public Book(String id, String title, String author) {
		this.id = id; this.title = title; this.author = author;
	}
	public String id() { return id; }
	public String title() { return title; }
	public String author() { return author; }
}