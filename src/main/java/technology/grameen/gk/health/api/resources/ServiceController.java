package technology.grameen.gk.health.api.resources;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.Service;
import technology.grameen.gk.health.api.responses.ExceptionResponse;
import technology.grameen.gk.health.api.responses.ResponseEnum;
import technology.grameen.gk.health.api.services.HealthServiceInterface;
import technology.grameen.gk.health.api.services.ServiceCategoryService;

import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity<Object> addService(@RequestBody Service req){

            Service center = healthServiceInterface.addService(req);
            return new ResponseEntity<>(center, HttpStatus.OK);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> handleException(HttpServletRequest req, DataIntegrityViolationException e) {
        return new ResponseEntity<>(new ExceptionResponse(Integer.parseInt(ResponseEnum.SERVICE_CATEGORY_NOT_AVAILABLE.getCode()),
                "Sorry, please try later "),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
