package di.service;

import java.util.List;

public interface RecordService {

    List<RecordDto> findRecordsByDate(String date);

    RecordDto save(RecordDto record);
}
