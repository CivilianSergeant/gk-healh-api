package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.ExceptionResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.HealthCenterService;

import java.util.List;


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

    @GetMapping("/api-id/{apiCenterId}")
    public ResponseEntity<IResponse> getCenterByApiCenterId(@PathVariable("apiCenterId") Long apiCenterId){
        return new ResponseEntity<>(new EntityResponse(HttpStatus.OK.value(),
                healthCenterService.getCenterByApiCenterId(apiCenterId)),HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<IResponse> addCenter(@RequestBody HealthCenter req){
        if(req.getName().isEmpty()){
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    "Center/Office Name Required"),HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(req.getCenterCode().isEmpty()){
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    "Center/Office Code Required"),HttpStatus.UNPROCESSABLE_ENTITY);
        }

        HealthCenter center = healthCenterService.addCenter(req);
        return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(),center), HttpStatus.OK);
    }

    @PutMapping(value = "/add")
    public ResponseEntity<IResponse> updateCenter(@RequestBody HealthCenter req){
        if(req.getId()==null){
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    "Center/Office id required to update"),HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(req.getName().isEmpty()){
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    "Center/Office Name Required"),HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if(req.getCenterCode().isEmpty()){
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    "Center/Office Code Required"),HttpStatus.UNPROCESSABLE_ENTITY);
        }
        HealthCenter center = null;
        try {
            center = healthCenterService.updateCenter(req);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage()),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(),center), HttpStatus.OK);
    }

    @GetMapping("/by-keyword/{keyword}")
    public ResponseEntity<IResponse> getCentersByKeyword(@PathVariable("keyword") String keyword){
        return new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                healthCenterService.getCentersByKeyword(keyword)),HttpStatus.OK);
    }

    @GetMapping("/by-office-type/{officeTypeId}")
    public ResponseEntity<IResponse> getCentersByOfficeTypeId(@PathVariable("officeTypeId") Integer officeTypeId){
        return new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                healthCenterService.getCentersByOfficeTypeId(officeTypeId)),HttpStatus.OK);
    }

    @GetMapping("/by-office-level/{officeLevel}")
    public ResponseEntity<IResponse> getCentersByOfficeLevel(@PathVariable("officeLevel") Integer officeLevel){
        return new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                healthCenterService.getCentersByOfficeLevel(officeLevel)),HttpStatus.OK);
    }
}
