package technology.grameen.gk.health.api.resources;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.OperationCategory;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.operation.OperationCategoryService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/operation-category")
public class OperationCategoryController {

    private static final Integer PAGE_SIZE = 10;
    private OperationCategoryService categoryService;

    public OperationCategoryController(OperationCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<IResponse> addCategory(@RequestBody OperationCategory operationCategory){
        return new ResponseEntity<>(new EntityResponse<>(
                HttpStatus.OK.value(),
                categoryService.addCategory(operationCategory)
        ), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<IResponse> getCategories(@RequestParam Optional<String> name,
                                                   @RequestParam Optional<Integer> page,
                                                   @RequestParam Optional<Integer> size,
                                                   @RequestParam Optional<String> sortBy,
                                                   @RequestParam Optional<Boolean> sortDesc){

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
                categoryService.getOperationCategories(name.orElse(""), pageable)
        ), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<IResponse> getCategories(){
       return new ResponseEntity<>(new EntityCollectionResponse<>(
               HttpStatus.OK.value(),
               categoryService.getOperationCategories()
       ),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IResponse> getById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(new EntityResponse<>(
                HttpStatus.OK.value(),
                categoryService.getById(id)
        ), HttpStatus.OK);
    }
}
