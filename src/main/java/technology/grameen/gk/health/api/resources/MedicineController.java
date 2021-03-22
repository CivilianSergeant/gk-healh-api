package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.Medicine;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.ExceptionResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.medicine.MedicineService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/medicine")
public class MedicineController {
    private MedicineService medicineService;

    public MedicineController (MedicineService medicineService){
        this.medicineService = medicineService;
    }

    @GetMapping(value="")
    public ResponseEntity<IResponse> list(){
        return new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                medicineService.getMedicines() ), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<IResponse> addMedicine(@RequestBody Medicine req){
        if(req.getName().isEmpty()){
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.OK.value(), "Name is Required")
                    , HttpStatus.OK);
        }
        Medicine medicine = medicineService.addMedicine(req);
        return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(), medicine), HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<IResponse> getMedicineById(@PathVariable("id") Long id){
      Optional <Medicine> medicine = medicineService.findById(id);
        return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(), medicine), HttpStatus.OK);
    }



}
