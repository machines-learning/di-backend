package di.service.impl;

import di.converter.PunchClockConversionFactory;
import di.domain.Record;
import di.domain.RecordRepository;
import di.service.RecordDto;
import di.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    private ConversionService conversionService = PunchClockConversionFactory.conversionService();

    @Override
    public List<RecordDto> findRecordsByDate(String date) {
        List<Record> records = this.recordRepository.findRecordsByDate(date);
        List<RecordDto> results = new ArrayList<>();
        if (records != null && records.size() > 0) {
            for (Record record : records) {
                if (record != null) {
                    results.add(this.conversionService.convert(record, RecordDto.class));
                }
            }
        }
        return results;
    }

    @Override
    public RecordDto save(RecordDto recordDto) {
        if(recordDto == null)
            return null;
        Record record = this.conversionService.convert(recordDto, Record.class);
        Record result = this.recordRepository.save(record);
        return this.conversionService.convert(result, RecordDto.class);
    }
}
