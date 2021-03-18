package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.entity.Prescription;
import technology.grameen.gk.health.api.responses.IResponse;

@RestController
@RequestMapping("/api/v1/prescription")
public class PrescriptionController {

    public ResponseEntity<IResponse> addPrescription(@RequestBody Prescription prescription){

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
