package object;

import dto.Book;
import dto.RentalRecord;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Librarian {

    /**
     * 책과 이용 가능한 개수를 Map으로 감싸서 반환해줌.
     *
     * @param title
     * @param bookCount
     * @return
     */
    public Map<Book, Integer> findBook(String title, int bookCount);

    /**
     * 책을 저장
     *
     * @param member
     * @param book
     */
    public void saveRentalRecord(Member member, Book book);

    /**
     * @return
     */
    public List<Book> getAllRentalTitles();

    /**
     * @return
     */
    public List<RentalRecord> getAllRentalStatistics();
}
