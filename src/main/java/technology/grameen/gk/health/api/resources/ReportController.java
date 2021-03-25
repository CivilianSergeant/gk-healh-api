package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.report.ReportService;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

    private  ReportService reportService;
    ReportController(ReportService reportService){
        this.reportService = reportService;
    }
    @GetMapping("/service-records")
    public ResponseEntity<IResponse> getServiceRecords(){
        return  new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                reportService.getPatientInvoiceSummery()),HttpStatus.OK);
    }
}
