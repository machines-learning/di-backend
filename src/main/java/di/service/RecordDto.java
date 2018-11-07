package di.service;

import lombok.Data;

@Data
public class RecordDto {

    private Long id;

    private Long timestamp;

    private String content;
}
