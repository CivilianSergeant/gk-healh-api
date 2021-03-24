package technology.grameen.gk.health.api.resources;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.projection.ServiceListItem;
import technology.grameen.gk.health.api.entity.Service;
import technology.grameen.gk.health.api.responses.ExceptionResponse;
import technology.grameen.gk.health.api.responses.ResponseEnum;
import technology.grameen.gk.health.api.services.HealthServiceInterface;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@CrossOrigin("${client-url}")
@RestController
@RequestMapping("/api/v1/service")
public class ServiceController {

    HealthServiceInterface healthServiceInterface;

    public ServiceController(HealthServiceInterface healthServiceInterface){
        this.healthServiceInterface = healthServiceInterface;
    }

    @RequestMapping(value = "")
    public ResponseEntity<List<ServiceListItem>> list(){
        return new ResponseEntity<>(healthServiceInterface.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Service> addService(@RequestBody Service req){

            Service service = healthServiceInterface.addService(req);
            return new ResponseEntity<>(service, HttpStatus.OK);

    }


    @PutMapping(value = "/update")
    public ResponseEntity<Service> updateService(@RequestBody Service req){

        Service service = healthServiceInterface.addService(req);
        return new ResponseEntity<>(service, HttpStatus.OK);

    }

    @GetMapping("/lab-services")
    public ResponseEntity<List<ServiceListItem>> labServices(){
        List<ServiceListItem> services = healthServiceInterface.getLabServices();
        return new ResponseEntity<>(services,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity< Optional<Service>> findServiceById(@PathVariable("id") Long id){
        Optional<Service> service = healthServiceInterface.findServiceById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> handleException(HttpServletRequest req, DataIntegrityViolationException e) {
        return new ResponseEntity<>(new ExceptionResponse(Integer.parseInt(ResponseEnum.SERVICE_CATEGORY_NOT_AVAILABLE.getCode()),
                "Sorry, please try later "),HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
