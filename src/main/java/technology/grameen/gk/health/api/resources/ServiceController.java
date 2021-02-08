package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.entity.Service;
import technology.grameen.gk.health.api.services.HealthServiceInterface;
import technology.grameen.gk.health.api.services.ServiceCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service")
public class ServiceController {

    HealthServiceInterface healthServiceInterface;

    public ServiceController(HealthServiceInterface healthServiceInterface){
        this.healthServiceInterface = healthServiceInterface;
    }

    @RequestMapping(value = "")
    public ResponseEntity<List<Service>> list(){
        return new ResponseEntity<>(healthServiceInterface.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addCategory(@RequestBody Service req){
        Service center = healthServiceInterface.addService(req);
        return new ResponseEntity<>(center, HttpStatus.OK);
    }
}
