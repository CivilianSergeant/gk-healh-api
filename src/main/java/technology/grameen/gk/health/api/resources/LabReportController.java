package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.LabTest;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.labtest.LabTestService;

@RestController
@RequestMapping("/api/v1/lab-test")
public class LabReportController {

    LabTestService labTestService;

    LabReportController(LabTestService labTestService){
        this.labTestService = labTestService;
    }

    @PostMapping("/add")
    public ResponseEntity<IResponse> createLabReport(@RequestBody LabTest labTest){
        LabTest labTest1 = labTestService.saveLabTest(labTest);
        return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(),
                labTest1), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<IResponse> getLabTestReports(){

        return  new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                labTestService.getLabTestReports()),HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<IResponse> getLabTestReportById(@PathVariable("id") Long id){

        return  new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(),
                labTestService.getLabTestReportById(id)),HttpStatus.OK);

    }

}
