package di.converter;

import di.domain.Record;
import di.service.RecordDto;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordConverters {

    public static class RecordDtoToRecordConverter implements Converter<RecordDto, Record> {

        @Override
        public Record convert(RecordDto recordDto) {
            Record record = new Record();
            record.setId(recordDto.getId());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = simpleDateFormat.format(recordDto.getTimestamp());
            record.setDate(date);

            Date timestamp = new Date(recordDto.getTimestamp());
            record.setTimestamp(timestamp);

            record.setContent(recordDto.getContent());
            return record;
        }
    }

    public static class RecordToRecordDtoConverter implements Converter<Record, RecordDto> {

        @Override
        public RecordDto convert(Record record) {
            RecordDto recordDto = new RecordDto();
            recordDto.setId(record.getId());
            recordDto.setTimestamp(record.getTimestamp().getTime());
            recordDto.setContent(record.getContent());
            return recordDto;
        }
    }


}
