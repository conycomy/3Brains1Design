package object;

import dto.Book;
import dto.RentalRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRentalHistory implements BookRentalHistory {

    private List<RentalRecord> records = new ArrayList<>();

    @Override
    public void save(Member member, Book book) {
        records.add(new RentalRecord(member, book));
    }

    @Override
    public List<Book> getAllTitles() {
        List<Book> titles = new ArrayList<>();

        for (RentalRecord record : records) {
            titles.add(record.getBook());
        }
        return titles;
    }

    @Override
    public List<RentalRecord> getRentalStatistics() {
        return new ArrayList<>(records);
    }

    // 실제 통계: 책별 대여 횟수를 조회
    public Map<Book, Long> getStatisticsAsMap() {
        Map<Book, Long> stats = new HashMap<>();

        for (RentalRecord record : records) {
            Book book = record.getBook();
            // 이미 집계된 경우 → +1, 아니면 1로 초기화
            if (stats.containsKey(book)) {
                stats.put(book, stats.get(book) + 1);
            } else {
                stats.put(book, 1L);
            }
        }

        return stats;
    }
}
