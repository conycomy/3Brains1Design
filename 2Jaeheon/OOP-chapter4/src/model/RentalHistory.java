package model;

import dto.RentalRecord;
import java.util.List;

public interface RentalHistory {

    void saveRentalRecord(RentalRecord rentalRecord);

    List<RentalRecord> getAllRentalRecords();
}
