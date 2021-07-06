package technology.grameen.gk.health.api.resources;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.OperationPackage;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.operation.OperationPackageService;

import javax.xml.ws.Response;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/operation-package")
public class OperationPackageController {

    private static final Integer PAGE_SIZE = 10;
    private OperationPackageService packageService;

    public OperationPackageController(OperationPackageService packageService) {
        this.packageService = packageService;
    }

    @PostMapping("/add")
    public ResponseEntity<IResponse> addPackage(@RequestBody OperationPackage operationPackage){
        return new ResponseEntity<>(new EntityResponse<>(
                HttpStatus.OK.value(),
                packageService.addPackage(operationPackage)
        ), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<IResponse> getPackages(){
        return new ResponseEntity<>(new EntityCollectionResponse<>(
                HttpStatus.OK.value(),
                packageService.getOperationPackages()
        ), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<IResponse> getPackages(@RequestParam Optional<String> name,
                                                 @RequestParam Optional<Integer> page,
                                                 @RequestParam Optional<Integer> size,
                                                 @RequestParam Optional<String> sortBy,
                                                 @RequestParam Optional<Boolean> sortDesc
                                                 ){

        String _sortBy = sortBy.orElse(null);
        _sortBy = (_sortBy.contains("active")) ? "isActive":_sortBy;
        Sort sort = null;

        if(!_sortBy.isEmpty()) {
            sort =   (sortDesc.orElse(false)) ? Sort.by(_sortBy).descending()
                    : Sort.by(_sortBy).ascending();
        }
        Pageable pageable = (sort!=null)? PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE),sort)
                : PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE));

        return new ResponseEntity<>(new EntityResponse<>(
                HttpStatus.OK.value(),
                packageService.getOperationPackages(name.orElse(""),pageable)
        ), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<IResponse> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(new EntityResponse<>(
                HttpStatus.OK.value(),
                packageService.getById(id)
        ), HttpStatus.OK);
    }
}
