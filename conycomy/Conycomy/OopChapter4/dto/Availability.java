package Conycomy.OopChapter4.dto;

public class Availability {
	public enum Status { AVAILABLE, NOT_FOUND, UNAVAILABLE } // 없음 / 대여중
	private final BookRequest request;
	private final Status status;
	private final Book matched; // AVAILABLE일 때만 의미 있음

	public Availability(BookRequest request, Status status, Book matched) {
		this.request = request; this.status = status; this.matched = matched;
	}
	public BookRequest request() { return request; }
	public Status status() { return status; }
	public Book matched() { return matched; }
}