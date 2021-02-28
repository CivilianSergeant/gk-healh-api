package technology.grameen.gk.health.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.entity.LabTestUnit;
import technology.grameen.gk.health.api.services.LabTestUnitService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service-units")
public class ServiceUnitController {

    @Autowired
    LabTestUnitService labTestUnitService;

    @GetMapping("")
    public ResponseEntity<List<LabTestUnit>> getUnits(){
        return new ResponseEntity<>(labTestUnitService.getAllUnits(), HttpStatus.OK);
    }
}
