package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.services.HealthCenterService;

import java.util.List;

@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping(value = "/api/v1/health-center")
public class HealthCenterController {

    private HealthCenterService healthCenterService;

    public HealthCenterController(HealthCenterService healthCenterService){
        this.healthCenterService = healthCenterService;
    }

    @RequestMapping(value = "")
    public ResponseEntity<List<HealthCenter>> list(){
        return new ResponseEntity<>(healthCenterService.getCenters(),HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addCenter(@RequestBody HealthCenter req){
        HealthCenter center = healthCenterService.addCenter(req);
        return new ResponseEntity<>(center, HttpStatus.OK);
    }
}
