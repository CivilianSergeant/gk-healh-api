package technology.grameen.gk.health.api.resources;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.MedicineGroup;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.medicine.MedicineGroupService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/medicine-group")
public class MedicineGroupController {

    private static final Integer PAGE_SIZE = 10;
    private MedicineGroupService medicineGroupService;

    MedicineGroupController (MedicineGroupService medicineGroupService){
        this.medicineGroupService = medicineGroupService;
    }

    @GetMapping("")
    public ResponseEntity<IResponse> getMedicineGroups(){

        return new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                this.medicineGroupService.getList()), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<IResponse> getMedicineBrands(@RequestParam Optional<String> name,
                                                       @RequestParam Optional<Integer> page,
                                                       @RequestParam Optional<Integer> size,
                                                       @RequestParam Optional<String> sortBy,
                                                       @RequestParam Optional<Boolean> sortDesc){
        String _sortBy = sortBy.orElse(null);
        Sort sort = null;

        if(!_sortBy.isEmpty()) {
            sort =   (sortDesc.orElse(false)) ? Sort.by(_sortBy).descending()
                    : Sort.by(_sortBy).ascending();
        }
        Pageable pageable = (sort!=null)? PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE),sort)
                : PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE));

        return new ResponseEntity<>(new EntityResponse<>(
                HttpStatus.OK.value(),
                medicineGroupService.getGroups(name.orElse(null),pageable)
        ),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<IResponse> addMedicineGroup(@RequestBody MedicineGroup medicineGroup){
        return new ResponseEntity<>(new EntityResponse<>(
                HttpStatus.OK.value(),
                medicineGroupService.addMedicineGroup(medicineGroup)
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IResponse> getGroupById(@PathVariable("id") Long id){
        return new ResponseEntity<>(new EntityResponse<>(
                HttpStatus.OK.value(),
                medicineGroupService.getBrandById(id)
        ), HttpStatus.OK);
    }
}
