package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.predefined.SpecimenService;

@RestController
@RequestMapping("/api/v1/specimens")
public class SpecimenController {

    SpecimenService specimenService;

    SpecimenController(SpecimenService specimenService){
        this.specimenService = specimenService;
    }

    @GetMapping("")
    public ResponseEntity<IResponse> getSpecimens(){
        return new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                this.specimenService.getAll()),HttpStatus.OK);
    }
}
