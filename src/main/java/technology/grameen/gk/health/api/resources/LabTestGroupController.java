package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.entity.LabTestGroup;
import technology.grameen.gk.health.api.repositories.LabTestGroupRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/lab-test-groups")
public class LabTestGroupController {

    LabTestGroupRepository labTestGroupRepository;

    LabTestGroupController(LabTestGroupRepository labTestGroupRepository){
        this.labTestGroupRepository = labTestGroupRepository;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<LabTestGroup>> getGroups(){
        return new ResponseEntity<>(labTestGroupRepository.findAll(), HttpStatus.OK);
    }

}
