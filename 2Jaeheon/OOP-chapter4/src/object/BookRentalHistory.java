package object;

import dto.Book;
import dto.RentalRecord;
import java.util.List;

public interface BookRentalHistory {

    public void save(Member member, Book book);

    public List<Book> getAllTitles();

    public List<RentalRecord> getRentalStatistics();
}
