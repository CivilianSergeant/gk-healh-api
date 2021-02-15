package technology.grameen.gk.health.api.resources;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.ServiceCategory;
import technology.grameen.gk.health.api.responses.ExceptionResponse;
import technology.grameen.gk.health.api.responses.ResponseEnum;
import technology.grameen.gk.health.api.services.ServiceCategoryService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/api/v1/service-category")
public class ServiceCategoryController {

    private ServiceCategoryService serviceCategoryService;

    public ServiceCategoryController(ServiceCategoryService serviceCategoryService){
        this.serviceCategoryService = serviceCategoryService;
    }

    @RequestMapping(value = "")
    public ResponseEntity<List<ServiceCategory>> list(){
        return new ResponseEntity<>(serviceCategoryService.getCategories(), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addCategory(@RequestBody ServiceCategory req){
        ServiceCategory center = serviceCategoryService.addCategory(req);
        return new ResponseEntity<>(center, HttpStatus.OK);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> handleException(HttpServletRequest req, DataIntegrityViolationException e) {
        return new ResponseEntity<>(new ExceptionResponse(Integer.parseInt(ResponseEnum.SERVICE_CATEGORY_NOT_UNIQUE.getCode()),
                "Sorry, please try later "),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
