package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.medicine.MedicineGroupService;

@RestController
@RequestMapping("/api/v1/medicine-group")
public class MedicineGroupController {

    private MedicineGroupService medicineGroupService;

    MedicineGroupController (MedicineGroupService medicineGroupService){
        this.medicineGroupService = medicineGroupService;
    }

    @GetMapping("")
    public ResponseEntity<IResponse> getMedicineGroups(){

        return new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                this.medicineGroupService.getList()), HttpStatus.OK);
    }
}
