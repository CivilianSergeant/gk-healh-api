package technology.grameen.gk.health.api.resources;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.projection.ServiceListItem;
import technology.grameen.gk.health.api.entity.Service;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.ExceptionResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.responses.ResponseEnum;
import technology.grameen.gk.health.api.services.HealthServiceInterface;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/service")
public class ServiceController {

    private final Integer PAGE_SIZE = 10;

    HealthServiceInterface healthServiceInterface;

    public ServiceController(HealthServiceInterface healthServiceInterface){
        this.healthServiceInterface = healthServiceInterface;
    }

    @RequestMapping(value = "")
    public ResponseEntity<IResponse> list(
                                          @RequestParam Optional<String> serviceName,
                                          @RequestParam Optional<Integer> page,
                                          @RequestParam Optional<Integer> size,
                                          @RequestParam Optional<String> sortBy,
                                          @RequestParam Optional<Boolean> sortDesc){

        String _sortBy = sortBy.orElse(null);
        _sortBy = (_sortBy.contains("active")) ? "isActive":_sortBy;
        //_sortBy = (_sortBy.contains("labTestGroup")) ? "labTestGroup":_sortBy;

        Sort sort = null;
        if(!_sortBy.isEmpty()) {
            sort =   (sortDesc.orElse(false)) ? Sort.by(_sortBy).descending()
                    : Sort.by(_sortBy).ascending();
        }
        Pageable pageable = (sort!=null)? PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE),sort)
                : PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE));

        return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(),
                healthServiceInterface.getAll(serviceName.orElse(""),pageable)), HttpStatus.OK);
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
