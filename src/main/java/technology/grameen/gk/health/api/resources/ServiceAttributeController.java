package technology.grameen.gk.health.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.LabTestAttribute;
import technology.grameen.gk.health.api.entity.Service;
import technology.grameen.gk.health.api.responses.AttributeCreationResponse;
import technology.grameen.gk.health.api.responses.ExceptionResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.responses.SimpleResponse;
import technology.grameen.gk.health.api.services.HealthCenterService;
import technology.grameen.gk.health.api.services.HealthServiceInterface;

import java.util.List;


@RestController
@RequestMapping("/api/v1/service-attribute")
public class ServiceAttributeController {


    @Autowired
    HealthServiceInterface healthServiceInterface;

    @PostMapping("/add")
    public ResponseEntity<IResponse> addServiceAttribute(@RequestBody Service service){
        try {
            healthServiceInterface.addServiceAttributes(service);
            return new ResponseEntity<>(new AttributeCreationResponse(HttpStatus.OK.value(),service), HttpStatus.OK);
        }catch (Exception ex){

            return new ResponseEntity<>(
                    new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),ex.getMessage()),
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<List<LabTestAttribute>> getServiceAttributes(@PathVariable("serviceId") Long serviceId){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<IResponse> deleteAttribute(@PathVariable("id") Long id){
        healthServiceInterface.deleteAttributeById(id);
        return new ResponseEntity<>(new SimpleResponse(HttpStatus.OK.value(),"Attribute Deleted"),
                    HttpStatus.OK);
    }
}
