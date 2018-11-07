package di.resource;

import di.service.RecordDto;
import di.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/record")
public class RecordResource {

    @Autowired
    private RecordService recordService;

    @RequestMapping(method = RequestMethod.GET, value = "/date/{date}")
    public List<RecordDto> findRecordsByDate(@PathVariable String date) {
        return this.recordService.findRecordsByDate(date);
    }

    @RequestMapping(method = RequestMethod.POST)
    public RecordDto save(@RequestBody RecordDto record) {
        return this.recordService.save(record);
    }

}
