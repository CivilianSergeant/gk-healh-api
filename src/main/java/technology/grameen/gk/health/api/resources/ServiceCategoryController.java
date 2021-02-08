package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.entity.ServiceCategory;
import technology.grameen.gk.health.api.services.ServiceCategoryService;

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
}
