package model;

import dto.Book;
import dto.RentalRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryRentalHistory implements RentalHistory {

    private final Map<Member, Book> memberRentalRecords;

    public InMemoryRentalHistory(Map<Member, Book> rentalHistories) {
        this.memberRentalRecords = rentalHistories;
    }

    @Override
    public void saveRentalRecord(RentalRecord rentalRecord) {
        // 랜탈 레코드를 메모리에 저장
        // 멤버와 책 정보를 저장함.
        Member member = rentalRecord.getMember();
        Book book = rentalRecord.getBook();

        memberRentalRecords.put(member, book);
    }

    @Override
    public List<RentalRecord> getAllRentalRecords() {
        List<RentalRecord> rentalRecords = new ArrayList<>();

        for (Map.Entry<Member, Book> entry : memberRentalRecords.entrySet()) {
            Member member = entry.getKey();
            Book book = entry.getValue();
            rentalRecords.add(new RentalRecord(member, book));
        }

        return rentalRecords;
    }
}
