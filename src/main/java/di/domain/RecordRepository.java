package di.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    @Override
    List<Record> findAll();

    List<Record> findRecordsByDate(String date);

    @Override
    Record save(Record record);
}
