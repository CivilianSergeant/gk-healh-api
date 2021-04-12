package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.requests.ServiceRecordSearch;
import technology.grameen.gk.health.api.requests.StatsRequest;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.responses.StatsResponse;
import technology.grameen.gk.health.api.services.report.ReportService;

import java.math.BigDecimal;
import java.util.Optional;

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

    @PostMapping("/service-records")
    public ResponseEntity<IResponse> getServiceRecords(@RequestBody ServiceRecordSearch serviceRecordSearch){
        return  new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                reportService.getPatientInvoiceSummery(serviceRecordSearch.getFromDate(),
                        serviceRecordSearch.getToDate())),HttpStatus.OK);
    }

    @PostMapping("/stats")
    public ResponseEntity<IResponse> getStats(@RequestBody StatsRequest req){
        HealthCenter healthCenter = new HealthCenter();
        healthCenter.setId(req.getId());
        healthCenter.setOfficeTypeId(req.getOfficeTypeId());
        healthCenter.setCenterCode(req.getCenterCode());


        Optional<BigDecimal> totalAmount = reportService.getPatientService().getTotalAmount(healthCenter,
                req.getFromDate(),req.getToDate());

        return new ResponseEntity<>(new StatsResponse(
                reportService.getPatientService().getAllPatientCount(healthCenter,
                        req.getFromDate(),req.getToDate()),
                reportService.getPatientService().getGbPatientCount(healthCenter,
                        req.getFromDate(), req.getToDate()),
                reportService.getPatientService().getNonGbPatientCount(healthCenter,
                        req.getFromDate(), req.getToDate()),
                totalAmount.orElse(BigDecimal.valueOf(0))),HttpStatus.OK);
    }
}
