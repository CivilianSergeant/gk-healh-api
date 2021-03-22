package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.medicine.MedicineBrandService;

@RestController
@RequestMapping("/api/v1/medicine-brand")
public class MedicineBrandController {

    private MedicineBrandService medicineBrandService;

    MedicineBrandController (MedicineBrandService medicineBrandService){
       this.medicineBrandService = medicineBrandService;
    }

    @GetMapping("")
    public ResponseEntity<IResponse> getMedicineBrands(){

        return  new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                this.medicineBrandService.getList()),HttpStatus.OK);

    }
}
